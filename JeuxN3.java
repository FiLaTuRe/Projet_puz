package com.vishesh.eight_puzzle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


@SuppressWarnings("deprecation")
public class JeuxN3 extends Activity {
   
   	private TextView nbrdeplacement;
	 	private TextView commentaire;
		 	private Button[] buttons;
			    private Boolean faux_mouvement =false;
			       	private static final Integer[] pcorect = new Integer[] {0,1,2,3,4,5,6,7,8};
				   	
						private ArrayList<Integer> cellules = new ArrayList<Integer>();
						    @Override
						        public void onCreate(Bundle savedInstanceState) {
							        super.onCreate(savedInstanceState);
								        setContentView(R.layout.vueniveau3);
									        buttons= tableaub();
for(int i=0;i<9;i++)   {
  this.cellules.add(i);
														           }
//cellule aleatoire dans le tableau
Collections.shuffle(this.cellules);     
remplir_g();
																				 																		               
nbrdeplament = (TextView) findViewById(R.id.compteur);																					      	   commentaire = (TextView) findViewById(R.id.coms);


																							   		for (int i = 1; i < 9; i++) {
																												buttons[i].setOnClickListener(new View.OnClickListener() {
																																public void onClick(View v) {
																																					fairebouger((Button) v);
																																									}
																																												});
																																														}
																																																
																																																		
																																																				nbrdeplacement.setText("0");
																																																						commentaire.setText(R.string.game_feedback_text);
																																																						    
																																																						    }
																																																						        public Button[] tableaub() {
																																																									Button[] bnt = new Button[9];
																																																											
																																																													bnt[0] = (Button) findViewById(R.id.Button00);
																																																															bnt[1] = (Button) findViewById(R.id.Button01);
																																																																	bnt[2] = (Button) findViewById(R.id.Button02);
																																																																			bnt[3] = (Button) findViewById(R.id.Button03);
																																																																					bnt[4] = (Button) findViewById(R.id.Button04);
																																																																							bnt[5] = (Button) findViewById(R.id.Button05);
																																																																									bnt[6] = (Button) findViewById(R.id.Button06);
																																																																											bnt[7] = (Button) findViewById(R.id.Button07);
																																																																													bnt[8] = (Button) findViewById(R.id.Button08);
																																																																															return bnt;
																																																																																}




																																																																																   // fonction qui fait bouger les bouton (tuiles) dans le tableau
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
																																																																																																																																																																																																																 	        {
																																																																																																																																																																																																																			           if(cellules.get(i)!= pcorect[i])
																																																																																																																																																																																																																				   	           {
																																																																																																																																																																																																																						   	        	        	   return;
																																																																																																																																																																																																																											   	           }
																																																																																																																																																																																																																													   	        }
																																																																																																																																																																																																																																	 commentaire.setText("Bravo vous avez gagnè ");
																																																																																																																																																																																																																																	 	}

																																																																																																																																																																																																																																			//fonction qui sert à remplir la grille
																																																																																																																																																																																																																																				public void remplir_g()
																																																																																																																																																																																																																																				    {
																																																																																																																																																																																																																																				    	 for(int i=0;i<9;i++)
																																																																																																																																																																																																																																					 	 {
																																																																																																																																																																																																																																						 		 int text= cellules.get(i);
																																																																																																																																																																																																																																								 		 AbsoluteLayout.LayoutParams absParams = 
																																																																																																																																																																																																																																										 			    (AbsoluteLayout.LayoutParams)buttons[text].getLayoutParams();
																																																																																																																																																																																																																																													    		 switch(i)
																																																																																																																																																																																																																																															 		 {case(0):
																																																																																																																																																																																																																																																	 		 
																																																																																																																																																																																																																																																			 			absParams.x = 5;
																																																																																																																																																																																																																																																									absParams.y = 5;
																																																																																																																																																																																																																																																												buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																															break;
																																																																																																																																																																																																																																																																	 case(1):
																																																																																																																																																																																																																																																																	 			
																																																																																																																																																																																																																																																																								absParams.x = 110;
																																																																																																																																																																																																																																																																												absParams.y = 5;
																																																																																																																																																																																																																																																																																buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																				break;
																																																																																																																																																																																																																																																																																						 case(2):
																																																																																																																																																																																																																																																																																						 			
																																																																																																																																																																																																																																																																																													absParams.x = 215;
																																																																																																																																																																																																																																																																																																	absParams.y = 5;
																																																																																																																																																																																																																																																																																																					buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																									break;
																																																																																																																																																																																																																																																																																																											 case(3):
																																																																																																																																																																																																																																																																																																											 			
																																																																																																																																																																																																																																																																																																																		absParams.x = 5;
																																																																																																																																																																																																																																																																																																																						absParams.y = 110;
																																																																																																																																																																																																																																																																																																																										buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																																														break;
																																																																																																																																																																																																																																																																																																																																 case(4):
																																																																																																																																																																																																																																																																																																																																 			
																																																																																																																																																																																																																																																																																																																																							absParams.x =110;
																																																																																																																																																																																																																																																																																																																																											absParams.y =110;
																																																																																																																																																																																																																																																																																																																																															buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																																																																			break;
																																																																																																																																																																																																																																																																																																																																																					 case(5):
																																																																																																																																																																																																																																																																																																																																																					 			 
																																																																																																																																																																																																																																																																																																																																																								 				absParams.x = 215;
																																																																																																																																																																																																																																																																																																																																																																absParams.y =110;
																																																																																																																																																																																																																																																																																																																																																																				buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																																																																																								break;
																																																																																																																																																																																																																																																																																																																																																																										 case(6):
																																																																																																																																																																																																																																																																																																																																																																										 			 
																																																																																																																																																																																																																																																																																																																																																																													 				absParams.x = 5;
																																																																																																																																																																																																																																																																																																																																																																																					absParams.y = 215;
																																																																																																																																																																																																																																																																																																																																																																																									buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																																																																																																													break;
																																																																																																																																																																																																																																																																																																																																																																																															 case(7):
																																																																																																																																																																																																																																																																																																																																																																																															 			 
																																																																																																																																																																																																																																																																																																																																																																																																		 				absParams.x = 110;
																																																																																																																																																																																																																																																																																																																																																																																																										absParams.y = 215;
																																																																																																																																																																																																																																																																																																																																																																																																														buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																																																																																																																																		break;
																																																																																																																																																																																																																																																																																																																																																																																																																				 case(8):
																																																																																																																																																																																																																																																																																																																																																																																																																				 			 
																																																																																																																																																																																																																																																																																																																																																																																																																							 				absParams.x = 215;
																																																																																																																																																																																																																																																																																																																																																																																																																															absParams.y = 215;
																																																																																																																																																																																																																																																																																																																																																																																																																																			buttons[text].setLayoutParams(absParams);
																																																																																																																																																																																																																																																																																																																																																																																																																																							break;
																																																																																																																																																																																																																																																																																																																																																																																																																																									 
																																																																																																																																																																																																																																																																																																																																																																																																																																									 		 
																																																																																																																																																																																																																																																																																																																																																																																																																																											 		 }
																																																																																																																																																																																																																																																																																																																																																																																																																																													 		
																																																																																																																																																																																																																																																																																																																																																																																																																																																	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																	 		}
																																																																																																																																																																																																																																																																																																																																																																																																																																																					
																																																																																																																																																																																																																																																																																																																																																																																																																																																						}

																																																																																																																																																																																																																																																																																																																																																																																																																																																							public int trouver_pos(int element)
																																																																																																																																																																																																																																																																																																																																																																																																																																																								{
																																																																																																																																																																																																																																																																																																																																																																																																																																																										int i=0;
																																																																																																																																																																																																																																																																																																																																																																																																																																																												 for(i=0;i<9;i++)
																																																																																																																																																																																																																																																																																																																																																																																																																																																												 	        {
																																																																																																																																																																																																																																																																																																																																																																																																																																																															           if(cellules.get(i)==element)
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														    
