package stringCheck.batch;

import stringCheck.jobflow.StringCheckJobFlow;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;

@Batch(name="StringCheckBatch")
public class StringCheckBatch extends BatchDescription {
	@Override
	protected void describe() {
		run(StringCheckJobFlow.class).soon();
	}

}
