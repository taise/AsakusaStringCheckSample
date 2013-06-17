package stringCheck.operator;

import sample.modelgen.dmdl.model.OutputModel;

import com.asakusafw.vocabulary.operator.Update;

public abstract class StringCheckOperator {

	private boolean checkBlank(String str){
		boolean checked = false;
		if(str.equals("'")) {
			checked = true;
		}
		return checked;
	}
	
	@Update
	public void updatedOutput(OutputModel output) {
		String id = output.getIdAsString();
		String checkedString = null;
		boolean checkedNull = false;
		boolean checkedBlank = false;
		
		try {
			 checkedString = output.getCheckedStringAsString();
			 checkedBlank = checkBlank(checkedString);
		     
		} catch(NullPointerException e) {
			checkedNull = true;
			checkedBlank = false;
		}
		output.setBooleanNull(checkedNull);
	    output.setBooleanBlank(checkedBlank);
	    
	     System.out.println("id: " + id);
	     System.out.println("checkedString: " + checkedString);
	     System.out.println("checkedNull: " + checkedNull);
	     System.out.println("checkedBlank: " + checkedBlank);
	     System.out.println("-------------------------------");
	}
}
