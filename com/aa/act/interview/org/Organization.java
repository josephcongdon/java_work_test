package com.aa.act.interview.org;

import java.util.Arrays;
import java.util.Optional;

public abstract class Organization {

	private Position root;
	
	public Organization() {
		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 * //Joseph Congdon notes
	 * The Position of COO is not filled by anyone inside the MyOrganization abstract class
	 * If the parameter 'title' listed in the Object "Name" matches the Object of "Position" parameter of 'title' return a string that confirms that the position.title has been filled by the Name.first Name.last.
	 *
	 */
	public Optional<Position> hire(Name person, String title) {
		//your code here
		Arrays.stream(new Position("").getClass().getMethods()).toArray();
		if (title.equals(createOrganization().getEmployee())){

		}

		return Optional.empty();
	}

	@Override
	public String toString() {
		return printOrganization(root, "");
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}
}
