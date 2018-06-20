package br.com.fmorais.androidbarcodegame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import br.com.fmorais.model.Battler;

public class StatsActivity extends Activity {

	private String hex;
	private Battler battler;
	private TextView name, hp, str, dex, inte, cha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			hex = extras.getString("HEX");
			battler = calculateStats(new Battler(), hex);
			battler.setName(calculateName(hex));
			name = (TextView) findViewById(R.id.name);
			hp = (TextView) findViewById(R.id.hp);
			str = (TextView) findViewById(R.id.str);
			dex = (TextView) findViewById(R.id.dex);
			inte = (TextView) findViewById(R.id.inte);
			cha = (TextView) findViewById(R.id.cha);
			
			name.setText("Name: " + battler.getName());
			hp.setText("Health: " + battler.getHealth().toString());
			str.setText("Strength: " + battler.getStrength().toString());
			dex.setText("Dexterity: " + battler.getDexterity().toString());
			inte.setText("Intelligence: " + battler.getIntelligence().toString());
			cha.setText("Charisma: " + battler.getCharisma().toString());
			
		}
	}

	private String calculateName(String hex) {
		
		String name = "";
		
		String[] nomes = { "Teste1", "Teste2" };
		
		switch (hex.charAt(0)) {
		case '0':
			name = "Death";
			break;
		case '1':
			name = "Saint";
			break;
		case '2':
			name = "Dark";
			break;
		case '3':
			name = "Force";
			break;
		case '4':
			name = "Strength";
			break;
		case '5':
			name = "Lick";
			break;
		case '6':
			name = "Ghoul";
			break;
		case '7':
			name = "Mad";
			break;
		case '8':
			name = "Foul";
			break;
		case '9':
			name = "Mild";
			break;
		case 'a':
			name = "Brain";
			break;
		case 'b':
			name = "Head";
			break;
		case 'c':
			name = "Hand";
			break;
		case 'd':
			name = "Fear";
			break;
		case 'e':
			name = "Dream";
			break;
		case 'f':
			name = "Cute";
			break;
		}
		
		switch (hex.charAt(1)) {
		case '0':
			name += "star";
			break;
		case '1':
			name += "man";
			break;
		case '2':
			name += "leer";
			break;
		case '3':
			name += "smell";
			break;
		case '4':
			name += "factor";
			break;
		case '5':
			name += "thriller";
			break;
		case '6':
			name += "rot";
			break;
		case '7':
			name += "y";
			break;
		case '8':
			name += "lock";
			break;
		case '9':
			name += "based";
			break;
		case 'a':
			name += "dog";
			break;
		case 'b':
			name += "dot";
			break;
		case 'c':
			name += "case";
			break;
		case 'd':
			name += "imp";
			break;
		case 'e':
			name += "kiss";
			break;
		case 'f':
			name += "dead";
			break;
		}
		
		return name;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stats, menu);
		return true;
	}

	public Battler calculateStats(Battler b, String hex) {

		System.out.println(b);
		for (char c : hex.toCharArray()) {
			switch (c) {
			case '0':
				b.setHealth(Math.abs(b.getHealth() + 100));
				b.setStrength(Math.abs(b.getStrength() + 100));
				b.setDexterity(Math.abs(b.getDexterity() - 20));
				b.setIntelligence(Math.abs(b.getIntelligence() - 40));
				b.setCharisma(Math.abs(b.getCharisma() - 140));
				break;
			case '1':
				b.setHealth(Math.abs(b.getHealth() + 100));
				b.setStrength(Math.abs(b.getStrength() + 90));
				b.setDexterity(Math.abs(b.getDexterity() - 10));
				b.setIntelligence(Math.abs(b.getIntelligence() - 100));
				b.setCharisma(Math.abs(b.getCharisma() - 80));
				break;
			case '2':
				b.setHealth(Math.abs(b.getHealth() - 100));
				b.setStrength(Math.abs(b.getStrength() - 100));
				b.setDexterity(Math.abs(b.getDexterity() + 20));
				b.setIntelligence(Math.abs(b.getIntelligence() + 80));
				b.setCharisma(Math.abs(b.getCharisma() + 100));
				break;
			case '3':
				b.setHealth(Math.abs(b.getHealth() - 100));
				b.setStrength(Math.abs(b.getStrength() + 100));
				b.setDexterity(Math.abs(b.getDexterity() - 50));
				b.setIntelligence(Math.abs(b.getIntelligence() - 50));
				b.setCharisma(Math.abs(b.getCharisma() + 100));
				break;
			case '4':
				b.setHealth(Math.abs(b.getHealth() - 50));
				b.setStrength(Math.abs(b.getStrength() + 100));
				b.setDexterity(Math.abs(b.getDexterity() + 20));
				b.setIntelligence(Math.abs(b.getIntelligence() - 20));
				b.setCharisma(Math.abs(b.getCharisma() + 50));
				break;
			case '5':
				b.setHealth(Math.abs(b.getHealth() + 200));
				b.setStrength(Math.abs(b.getStrength() - 50));
				b.setDexterity(Math.abs(b.getDexterity() - 25));
				b.setIntelligence(Math.abs(b.getIntelligence() - 25));
				b.setCharisma(Math.abs(b.getCharisma() - 100));
				break;
			case '6':
				b.setHealth(Math.abs(b.getHealth() - 10));
				b.setStrength(Math.abs(b.getStrength() + 120));
				b.setDexterity(Math.abs(b.getDexterity() - 10));
				b.setIntelligence(Math.abs(b.getIntelligence() - 80));
				b.setCharisma(Math.abs(b.getCharisma() - 20));
				break;
			case '7':
				b.setHealth(Math.abs(b.getHealth() + 110));
				b.setStrength(Math.abs(b.getStrength() - 100));
				b.setDexterity(Math.abs(b.getDexterity() - 50));
				b.setIntelligence(Math.abs(b.getIntelligence() + 50));
				b.setCharisma(Math.abs(b.getCharisma() -10));
				break;
			case '8':
				b.setHealth(Math.abs(b.getHealth() + 40));
				b.setStrength(Math.abs(b.getStrength() + 140));
				b.setDexterity(Math.abs(b.getDexterity() - 60));
				b.setIntelligence(Math.abs(b.getIntelligence() + 20));
				b.setCharisma(Math.abs(b.getCharisma() - 140));
				break;
			case '9':
				b.setHealth(Math.abs(b.getHealth() - 150));
				b.setStrength(Math.abs(b.getStrength() + 100));
				b.setDexterity(Math.abs(b.getDexterity() - 20));
				b.setIntelligence(Math.abs(b.getIntelligence() + 50));
				b.setCharisma(Math.abs(b.getCharisma() + 20));
				break;
			case 'a':
				b.setHealth(Math.abs(b.getHealth() - 100));
				b.setStrength(Math.abs(b.getStrength() + 100));
				b.setDexterity(Math.abs(b.getDexterity() + 20));
				b.setIntelligence(Math.abs(b.getIntelligence() + 80));
				b.setCharisma(Math.abs(b.getCharisma() - 100));
				break;
			case 'b':
				b.setHealth(Math.abs(b.getHealth() + 100));
				b.setStrength(Math.abs(b.getStrength() - 100));
				b.setDexterity(Math.abs(b.getDexterity() - 20));
				b.setIntelligence(Math.abs(b.getIntelligence() - 80));
				b.setCharisma(Math.abs(b.getCharisma() + 100));
				break;
			case 'c':
				b.setHealth(Math.abs(b.getHealth() - 100));
				b.setStrength(Math.abs(b.getStrength() - 100));
				b.setDexterity(Math.abs(b.getDexterity() + 150));
				b.setIntelligence(Math.abs(b.getIntelligence() - 50));
				b.setCharisma(Math.abs(b.getCharisma() + 100));		
				break;
			case 'd':
				b.setHealth(Math.abs(b.getHealth() + 50));
				b.setStrength(Math.abs(b.getStrength() + 50));
				b.setDexterity(Math.abs(b.getDexterity() - 10));
				b.setIntelligence(Math.abs(b.getIntelligence() - 80));
				b.setCharisma(Math.abs(b.getCharisma() - 10));
				break;
			case 'e':
				b.setHealth(Math.abs(b.getHealth() + 100));
				b.setStrength(Math.abs(b.getStrength() + 50));
				b.setDexterity(Math.abs(b.getDexterity() - 180));
				b.setIntelligence(Math.abs(b.getIntelligence() + 80));
				b.setCharisma(Math.abs(b.getCharisma() - 50));
				break;
			case 'f':
				b.setHealth(Math.abs(b.getHealth() + 5));
				b.setStrength(Math.abs(b.getStrength() + 5));
				b.setDexterity(Math.abs(b.getDexterity() - 5));
				b.setIntelligence(Math.abs(b.getIntelligence() - 10));
				b.setCharisma(Math.abs(b.getCharisma() + 5));
				break;

			}
		}
		return b;
	}
}
