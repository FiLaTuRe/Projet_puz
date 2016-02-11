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
}  
 // fonction qui fait bouger les bouton (tuiles) dans le tableau
 @TargetApi(Build.VERSION_CODES.KITKAT)
 public void fairebouger(final Button b) {
 faux_mouvement =true;
 int b_text,b_pos,zuk_pos;
 b_text=Integer.parseInt((String) b.getText());
  b_pos= trouver_pos(b_text);
  zuk_pos= trouver_pos(0);
  switch(zuk_pos)
   {
   case(0):
   if(b_pos==1||b_pos==3)
   faux_mouvement =false;
   break;
   case(1):
   if(b_pos==0||b_pos==2||b_pos==4)
   faux_mouvement =false;
   break;
   case(2):
   if(b_pos==1||b_pos==5)
   faux_mouvement =false;
   break;
   case(3):
   if(b_pos==0||b_pos==4||b_pos==6)
   faux_mouvement =false;
   break;
   case(4):
   if(b_pos==1||b_pos==3||b_pos==5||b_pos==7)
   faux_mouvement =false;
   break;
   case(5):
   if(b_pos==2||b_pos==4||b_pos==8)
   faux_mouvement =false;
   break;
   case(6):
   if(b_pos==3||b_pos==7)
   faux_mouvement =false;
   break;
   case(7):
   if(b_pos==4||b_pos==6||b_pos==8)
   faux_mouvement =false;
   break;
   case(8):
   if(b_pos==5||b_pos==7)
   faux_mouvement =false;
   break;
   }
   if(faux_mouvement ==true)
   {
   commentaire.setText("Deplacement impossible");
   return;
   }
   commentaire.setText("Bouger");
   cellules.remove(b_pos);
   cellules.add(b_pos, 0);
   cellules.remove(zuk_pos);
   cellules.add(zuk_pos, b_text);
   remplir_g();
   nbrdeplacement.setText(Integer.toString(Integer.parseInt((String) nbrdeplacement.getText()) + 1));
   for(int i=0;i<9;i++)
   { if(cellules.get(i)!= pcorect[i])
   {
   return;
   }
   }
   commentaire.setText("Bravo vous avez gagnè ");
   niv2.setCursorVisible(true);
   niv2.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
   Intent intent = new Intent(JeuxN1.this, JeuxN22.class);
   startActivity(intent);
   }
   });
   }
