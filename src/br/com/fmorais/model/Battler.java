package br.com.fmorais.model;

public class Battler {
	
	private String name;
	private Integer health;
	private Integer strength;
	private Integer dexterity;
	private Integer intelligence;
	private Integer charisma;
	
	public Battler(String name, Integer health, Integer strength, Integer dexterity,
			Integer intelligence, Integer charisma) {
		super();
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.charisma = charisma;
	}
	
	public Battler() {
		super();
		this.health = 1000;
		this.strength = 1000;
		this.dexterity = 1000;
		this.intelligence = 1000;
		this.charisma = 1000;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public Integer getDexterity() {
		return dexterity;
	}
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}
	public Integer getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	public Integer getCharisma() {
		return charisma;
	}
	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}
	
}
