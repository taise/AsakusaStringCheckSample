package stringCheck.jobflow;

import org.junit.Test;

import sample.modelgen.dmdl.model.CheckedString;
import sample.modelgen.dmdl.model.OutputModel;

import com.asakusafw.testdriver.FlowPartTester;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.Out;

public class StringCheckJobFlowTest {
	@Test
	public void testStringCheckJobFlow() {
		FlowPartTester tester = new FlowPartTester(getClass());
		
		In<CheckedString> input = tester.input("input", CheckedString.class)
				.prepare("checked_string.xls#input");
		
		Out<OutputModel> output = tester.output("output", OutputModel.class)
				.verify("output_model.xls#output", "output_model.xls#rule");
		
		FlowDescription flowpart = new StringCheckJobFlow(input, output);
		tester.runTest(flowpart);
	}

}
