package by.epam.site.entity;

public enum Role {
	ADMINISTRATOR("administrator"),
	MANAGER("manager"),
	CLIENT("client");

	private String name;

	Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name.toLowerCase();
	}

	public Integer getIdentity() {
		return ordinal();
	}

	public static Role getByIdentity(Integer identity) {
		return Role.values()[identity];
	}

	@Override
	public String toString() {
		return "Role{" + "name='" + name + '\'' + '}';
	}
}
