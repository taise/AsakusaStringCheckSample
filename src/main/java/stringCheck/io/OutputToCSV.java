package stringCheck.io;

import sample.modelgen.dmdl.csv.AbstractOutputModelCsvOutputDescription;

public class OutputToCSV extends AbstractOutputModelCsvOutputDescription {
	
	@Override
	public String getBasePath() {
		return "sample/output/";
	}
	
	@Override
	public String getResourcePattern() {
		return "output.csv";
	}

}
