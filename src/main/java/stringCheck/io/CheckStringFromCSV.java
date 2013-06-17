package stringCheck.io;

import sample.modelgen.dmdl.csv.AbstractCheckedStringCsvInputDescription;

public class CheckStringFromCSV extends AbstractCheckedStringCsvInputDescription {
	
	@Override
	public String getBasePath() {
		return "sample/input/";
	}
	
	@Override
	public String getResourcePattern() {
		return "checked_string.csv";
	}

}
