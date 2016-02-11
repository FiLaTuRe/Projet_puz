import android.content.Intent;

import android.os.Bundle;

import android.view.Menu;

import android.view.MenuInflater;

import android.view.MenuItem;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;


public class main extends Activity {
 
@Override
        
public void onCreate(Bundle savedInstanceState) {
	        
super.onCreate(savedInstanceState);
		     
setContentView(R.layout.main);
		           
Button jouer=(Button) findViewById(R.id.jouer);
			      
 jouer.setOnClickListener(new OnClickListener() {

// apelle de la vue du premier niveau
			      	
@Override
Intent intent = new Intent(getApplicationContext(), JeuxN1.class);
		
startActivity(intent);
}
});
										        
  }
											      
											 



