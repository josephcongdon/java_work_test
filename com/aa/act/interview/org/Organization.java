package com.aa.act.interview.org;

import java.util.*;

public abstract class Organization {

	private Position root;
	private int EmployeeCounter;

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
	 *
	 *
	 */


	public Optional<Position> hire(Name person, String title) {
		switch(title) {
			case "CEO":
				System.out.println("The following Positions have just been filled");
				this.root.setEmployee(Optional.of(new Employee(1, person)));
				break;
			case "President":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("President")){
						position.setEmployee(Optional.of(new Employee(2, person)));
					}
				}
				break;
			case "VP Finance":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("President")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Finance")){
								subPosition.setEmployee(Optional.of(new Employee(3, person)));
							}
						}
					}
				}
				break;
			case "COO":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("President")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("COO")){
								subPosition.setEmployee(Optional.of(new Employee(4, person)));
							}
						}
					}
				}
				break;
			case "VP Marketing":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("President")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Marketing")){
								subPosition.setEmployee(Optional.of(new Employee(5, person)));
							}
						}
					}
				}
				break;
			case "VP Sales":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("President")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Sales")){
								subPosition.setEmployee(Optional.of(new Employee(6, person)));
							}
						}
					}
				}
				break;
			case "Salesperson":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("President")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Sales")){
								for (Position subSubPosition : subPosition.getDirectReports()){
								subSubPosition.setEmployee(Optional.of(new Employee(7, person)));
								}
							}
						}
					}
				}
				break;
			case "CIO":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("CIO")){
						position.setEmployee(Optional.of(new Employee(8, person)));
					}
				}
				break;
			case "VP Infrastructure":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("CIO")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Infrastructure")){
								subPosition.setEmployee(Optional.of(new Employee(9, person)));
							}
						}
					}
				}
				break;
			case "VP Technology":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("CIO")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Technology")){
								subPosition.setEmployee(Optional.of(new Employee(10, person)));
							}
						}
					}
				}
				break;
			case "Director Enterprise Architecture":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("CIO")){
						for (Position subPosition : position.getDirectReports()){
							if (subPosition.getTitle().equals("VP Technology")){
								for (Position sudoSubPosition : subPosition.getDirectReports()){
									sudoSubPosition.setEmployee(Optional.of(new Employee(11, person)));
								}
							}
						}
					}
				}
				break;
			case "Director Customer Technology":
				for (Position position : this.root.getDirectReports()){
					if (position.getTitle().equals("CIO")){
						for (Position sudoPosition : position.getDirectReports()){
							if (sudoPosition.getTitle().equals("VP Technology")){
								for (Position subSubPosition : sudoPosition.getDirectReports()){
									if (subSubPosition.getTitle().equals("Director Customer Technology")) {
										subSubPosition.setEmployee(Optional.of(new Employee(12, person)));
									}
								}
							}
						}
					}
				}
				break;

			default:

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
