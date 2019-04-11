package by.epam.site.entity;

public enum Role {
	ADMINISTRATOR("администратор"),
	MANAGER("менеджер"),
	Client("клиент");

	private String name;

	private Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
