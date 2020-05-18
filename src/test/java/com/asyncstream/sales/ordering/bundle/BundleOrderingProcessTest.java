package com.asyncstream.sales.ordering.bundle;

import com.asyncstream.sales.ordering.bundle.delegate.BundleProcessStart;
import com.asyncstream.sales.ordering.bundle.delegate.ConfirmDeliveryAgent;
import com.asyncstream.sales.ordering.bundle.delegate.ProcessOrder;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.scenario.ProcessScenario;
import org.camunda.bpm.scenario.Scenario;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Deployment(resources = {
        "bpmn/bundle-ordering-process.bpmn",
        "bpmn/singleitem-ordering-process.bpmn",
        "dmn/identify-shipping-agent.dmn"
})
public class BundleOrderingProcessTest {

    @Rule
    @ClassRule
    public static ProcessEngineRule rule =
            TestCoverageProcessEngineRuleBuilder.create()
                    .withDetailedCoverageLogging().build();


    // Mock all waitstates in main process and call activity with a scenario
    @Mock private ProcessScenario bundleOrderApplication;
    @Mock private ProcessScenario singleOrderProcess;

    private Map<String, Object> variables;

    @Before
    public void setupDefaultScenario() {

        MockitoAnnotations.initMocks(this);
        Mocks.register("bundleProcessStart", new BundleProcessStart());
        Mocks.register("processOrder",new ProcessOrder());
        Mocks.register("confirmDeliveryAgent",new ConfirmDeliveryAgent());
        //Mocks.register("orderDeliveries", new ArrayList<>());

        List<String> deliveries = new ArrayList<>();
        deliveries.add("1");
        deliveries.add("2");
        deliveries.add("3");

        variables = Variables.createVariables()
                .putValue("orderId", "X4399T00")
                .putValue("orderDeliveries", deliveries);
                //.putValue("order", "VW");

        when(bundleOrderApplication.runsCallActivity("CallActivitySingleOrderProcessing"))
                .thenReturn(Scenario.use(singleOrderProcess));

        when(singleOrderProcess.waitsAtUserTask("Task_Packing")).thenReturn((task) -> {
            task.complete(withVariables("packingType", "Bubble Bags"));
        });
    }

    @Test
    public void testGlassItemOrderingScenario() {
        when(singleOrderProcess.waitsAtUserTask("Task_Packing")).thenReturn((task) -> {
            task.complete(withVariables("packingType", "Packing Peanuts"));
        });

        Scenario scenario = Scenario.run(bundleOrderApplication)
                .startByKey("bundle_ordering_process", variables)
                .execute();

        assertThat(scenario.instance(bundleOrderApplication)).calledProcessInstance("singleitem_ordering_process");
        verify(bundleOrderApplication,times(3)).hasCompleted("CallActivitySingleOrderProcessing");
        verify(bundleOrderApplication, times(3)).hasCompleted("Task_Delivery");
        verify(bundleOrderApplication).hasFinished("EndEventDeliveryCompleted");

        //verify(documentRequest, never()).hasCompleted("ReceiveTaskWaitForDocuments");

    }


}
