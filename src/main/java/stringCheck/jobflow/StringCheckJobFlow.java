package stringCheck.jobflow;

import sample.modelgen.dmdl.model.CheckedString;
import sample.modelgen.dmdl.model.OutputModel;
import stringCheck.io.CheckStringFromCSV;
import stringCheck.io.OutputToCSV;
import stringCheck.operator.StringCheckOperatorFactory;
import stringCheck.operator.StringCheckOperatorFactory.UpdatedOutput;


import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory.Extend;

@JobFlow(name="StringCheckJobFlow")
public class StringCheckJobFlow extends FlowDescription {
	
	final In<CheckedString> checkedString;
	final Out<OutputModel> output;
	final CoreOperatorFactory cp = new CoreOperatorFactory();
	
	public StringCheckJobFlow(
			@Import(name="checkedString", description=CheckStringFromCSV.class)
			In<CheckedString> checkedString,
			@Export(name="output", description=OutputToCSV.class)
			Out<OutputModel> output
			){
		this.checkedString = checkedString;
		this.output = output;
	}
	
	@Override
	protected void describe(){
		StringCheckOperatorFactory op = new StringCheckOperatorFactory();
		
		Extend<OutputModel> extended = cp.extend(checkedString, OutputModel.class);
		
	    UpdatedOutput updated = op.updatedOutput(extended);
	   
	    output.add(updated.out);
	}
}
