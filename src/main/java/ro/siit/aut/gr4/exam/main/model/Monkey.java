package ro.siit.aut.gr4.exam.main.model;

public class Monkey {
	public Monkey(boolean isSmiling) {
		setSmiling(isSmiling);
	}
	private boolean smiling;

	public boolean isSmiling() {
		return smiling;
	}

	private void setSmiling(boolean smiling) {
		this.smiling = smiling;
	}
}
