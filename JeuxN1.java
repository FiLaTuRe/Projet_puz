package com.vishesh.eight_puzzle;
import java.util.ArrayList;
import java.util.Collections;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;
@SuppressWarnings("deprecation")
public class JeuxN1 extends Activity {
   
private TextView nbrdeplacement;
private TextView commentaire;
private Button[] buttons;
Button niv2;
private Boolean faux_mouvement =false;
private static final Integer[] pcorect = new Integer[] {0,1,2,3,4,5,6,7,8};

private ArrayList<Integer> cellules = new ArrayList<Integer>();
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.vueniveau1);
buttons= tableaub();

niv2 = (Button) findViewById(R.id.n2);
//niv2.setCursorVisible(false);
							       
for(int i=0;i<9;i++) {
this.cellules.add(i) }
//cellule aleatoire dans le tableau
Collections.shuffle(this.cellules);
															        
remplir_g();
nbrdeplacement = (TextView) findViewById(R.id.compteur);
  commentaire = (TextView) findViewById(R.id.coms);
  //execution de la fonction de depacemet des tuiles apres click 
  for (int i = 1; i < 9; i++) {
  buttons[i].setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
fairebouger((Button) v);
}
});}
nbrdeplacement.setText("0");

commentaire.setText(R.string.game_feedback_text);
}  c un comes
:x
