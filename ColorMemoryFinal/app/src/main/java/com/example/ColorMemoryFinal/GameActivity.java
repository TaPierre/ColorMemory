package com.example.ColorMemoryFinal;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ColorMemoryFinal.Others.GameSettings;

import java.util.ArrayList;
import java.util.List;


public class GameActivity extends AppCompatActivity implements
        View.OnClickListener {

        int minLights, maxLights;
        Double currentWeight;
        int stage =1;
        int mode;
        double score;
        int speed=500;
        int nbLifes;
        TextView timeLeft;
        TextView life;
        TextView scoreView;
        Button black;
        Button yellow;
        Button blue;
        Button red;
        Button grey;
        Button green;
        Button pink;
        Button orange;
        Button purple;
        Button lightgreen;
        Button darkgreen;
        Button darkblue;

        List<Button> CollectOfButton = new ArrayList<Button>();
        List<Drawable> CollectOfCollor= new ArrayList<Drawable >();
        GameSettings Settings= new GameSettings();
        List<Button> fullAnswer = new ArrayList<Button>();
        List<Button> Answer = new ArrayList<Button>();

        public boolean TimeOutChrono()
        {

            Handler handler = new Handler();
            timeLeft.setText("Vous avez "+ fullAnswer.size()*2+" seconde dispo");
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (Settings.getAnswer()==true)
                    {
                        nbLifes = nbLifes -1;
                        RefreshVie();
                        if (nbLifes <1)
                        {
                            Toast.makeText(getApplicationContext(), "Vous avez perdu ! Retournez au menu pour recommencer", Toast.LENGTH_LONG).show();
                        }else
                        {
                            startGame();
                        }
                    }

                }
            }, 2000* fullAnswer.size());
            return true;
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            Bundle bundle=getIntent().getExtras();

            setContentView(R.layout.game_mode);
            minLights =bundle.getInt("LightCount");
            maxLights =bundle.getInt("ManLigh");
            mode=bundle.getInt("mode");
            score=bundle.getDouble("Score");

            if (1==mode)
            {
                currentWeight =1.0;
            }else  if(2==mode)
            {
                currentWeight =1.5;
            }else if(3==mode)
            {
                currentWeight =2.0;
            }
            else  if(4==mode)
            {
                currentWeight =1.5;

            }
            startingRules(bundle.getInt("blocCount"), minLights);
            Init();
            Utils.PrintScore(score, scoreView);
            startGame();

        }
        public  void startGame ()
        {

               Settings.setIndexBtnAnswer(0);
               Utils.disableButtons(CollectOfButton,Settings.getCurrentBlocsCount());
               fullAnswer.clear();
               Answer.clear();
               Settings.setAnswer(false);
               Utils.offButtons(CollectOfButton);
               fullAnswer =Utils.AskQuestion(Settings.getCurrentBlocsCount(),CollectOfButton,Settings.getCurrentLightsCount());
               startEnigma();
               if (mode==4)
               {
                   TimeOutChrono();
               }
        }
        public  void RefreshVie()
        {
            life.setText(Integer.toString(nbLifes));
        }
        public  void startingRules(int Bloc, int LightCount)
        {
            Settings.setCurrentBlocsCount(Bloc);
            Settings.setCurrentLightsCount(LightCount);
        }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonNoir:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(0));
                }
                break;
            case R.id.buttonvertdark:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(1));
                }
                break;

            case R.id.buttonBleue:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(2));
                }
                break;
            case R.id.buttonrouge:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(3));
                }
                break;
            case R.id.buttonjaune:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(4));
                }
                break;
            case R.id.buttonbluedark:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(5));
                }
                break;
            case R.id.buttonGris:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(6));
                }
                break;
            case R.id.buttonVertclari:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(7));
                }
                break;
            case R.id.buttonvert:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(8));
                }
                break;
            case R.id.buttonrose:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(9));
                }
                break;
            case R.id.buttonOrange:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(10));
                }
                break;
            case R.id.buttonviolet:
                if (Settings.getAnswer()==true) {
                    addAnswerButton(CollectOfButton.get(11));
                }
                break;

            default:
                break;
        }
    }

        public void Init()
        {
            life = findViewById( R.id.textvie );
            scoreView = findViewById( R.id.Score_view );
            timeLeft = findViewById( R.id.Text_SecondeOk );

            black = findViewById( R.id.buttonNoir );
            darkgreen = findViewById( R.id.buttonvertdark );
            blue = findViewById( R.id.buttonBleue );
            red = findViewById( R.id.buttonrouge );
            yellow = findViewById( R.id.buttonjaune );
            darkblue = findViewById( R.id.buttonbluedark );
            grey = findViewById( R.id.buttonGris );
            lightgreen = findViewById( R.id.buttonVertclari );
            green = findViewById( R.id.buttonvert );
            pink = findViewById( R.id.buttonrose );
            orange = findViewById( R.id.buttonOrange );
            purple = findViewById( R.id.buttonviolet );

            CollectOfButton.add(black);
            CollectOfButton.add(darkgreen);
            CollectOfButton.add(blue);
            CollectOfButton.add(red);
            CollectOfButton.add(yellow);
            CollectOfButton.add(darkblue);
            CollectOfButton.add(grey);
            CollectOfButton.add(lightgreen);
            CollectOfButton.add(green);
            CollectOfButton.add(pink);
            CollectOfButton.add(orange);
            CollectOfButton.add(purple);

            CollectOfCollor.add(black.getBackground());
            CollectOfCollor.add(darkgreen.getBackground());
            CollectOfCollor.add(blue.getBackground());
            CollectOfCollor.add(red.getBackground());
            CollectOfCollor.add(yellow.getBackground());
            CollectOfCollor.add(darkblue.getBackground());
            CollectOfCollor.add(grey.getBackground());
            CollectOfCollor.add(lightgreen.getBackground());
            CollectOfCollor.add(green.getBackground());
            CollectOfCollor.add(pink.getBackground());
            CollectOfCollor.add(orange.getBackground());
            CollectOfCollor.add(purple.getBackground());

            for (Button button :CollectOfButton)
            {
                button.setOnClickListener(this);
            }

            if (mode==4)
            {
                nbLifes =3;
            }
            else
            {
                nbLifes =2;
            }
            RefreshVie();
        }

        public  void startEnigma()
        {
            Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(0).setBackground(Utils.RetrieveColor(fullAnswer.get(0),CollectOfButton,CollectOfCollor));
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    Utils.offButtons(CollectOfButton);
                                }
                            }, speed);
                }
            }, speed);
            if (Settings.getCurrentLightsCount()==1)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*3);

                return ;
            }

            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(1).setBackground(Utils.RetrieveColor(fullAnswer.get(1),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*3);
            if (Settings.getCurrentLightsCount()==2)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*5);
                return ;
            }

            Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(2).setBackground(Utils.RetrieveColor(fullAnswer.get(2),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*5);
            if (Settings.getCurrentLightsCount()==3)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*7);
                return ;
            }

            Handler handler4 = new Handler();
            handler4.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(3).setBackground(Utils.RetrieveColor(fullAnswer.get(3),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*7);
            if (Settings.getCurrentLightsCount()==4)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*9);
                return ;
            }

            Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(4).setBackground(Utils.RetrieveColor(fullAnswer.get(4),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*9);
            if (Settings.getCurrentLightsCount()==5)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*11);
                return ;
            }

            Handler handler6 = new Handler();
            handler6.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(5).setBackground(Utils.RetrieveColor(fullAnswer.get(5),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*12);
            if (Settings.getCurrentLightsCount()==6)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*14);
                return ;
            }

            Handler handler7 = new Handler();
            handler7.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(6).setBackground(Utils.RetrieveColor(fullAnswer.get(6),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*15);
            if (Settings.getCurrentLightsCount()==7)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*17);
                return ;
            }

            Handler handler8 = new Handler();
            handler8.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(7).setBackground(Utils.RetrieveColor(fullAnswer.get(7),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*18);
            if (Settings.getCurrentLightsCount()==8)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*20);
                return ;
            }

            Handler handler9 = new Handler();
            handler9.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(8).setBackground(Utils.RetrieveColor(fullAnswer.get(8),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*21);
            if (Settings.getCurrentLightsCount()==9)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*23);
                return ;
            }

            Handler handler10 = new Handler();
            handler10.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(9).setBackground(Utils.RetrieveColor(fullAnswer.get(9),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*24);
            if (Settings.getCurrentLightsCount()==10)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*26);
                return ;
            }
            Handler handler11 = new Handler();
            handler11.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(10).setBackground(Utils.RetrieveColor(fullAnswer.get(10),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*27);
            if (Settings.getCurrentLightsCount()==11)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*29);
                return ;
            }
            Handler handler12 = new Handler();
            handler12.postDelayed(new Runnable() {
                public void run() {
                    Utils.offButtons(CollectOfButton);
                    fullAnswer.get(11).setBackground(Utils.RetrieveColor(fullAnswer.get(11),CollectOfButton,CollectOfCollor));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Utils.offButtons(CollectOfButton);
                        }
                    }, speed);
                }
            }, speed*30);
            if (Settings.getCurrentLightsCount()==12)
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Utils.onButtons(CollectOfButton,CollectOfCollor);
                        Settings.setAnswer(true);
                    }
                }, speed*32);
                return ;
            }
        }
        public boolean CheckMatchBtwAnsAndRes(int index)
        {
            if (Answer.get(index)== fullAnswer.get(index))
            {
                Settings.setIndexBtnAnswer(Settings.getIndexBtnAnswer()+1);
                return  true;
            }
            else
            {
                Settings.setIndexBtnAnswer(Settings.getIndexBtnAnswer()+1);
                return  false;
            }
        }
        public  void addAnswerButton(Button btn)
        {
            Answer.add(btn);
            if (CheckMatchBtwAnsAndRes(Settings.getIndexBtnAnswer())==false && nbLifes >0)
            {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                nbLifes = nbLifes -1;
                RefreshVie();
                if (nbLifes <1)
                {
                    Toast.makeText(getApplicationContext(), "Vous avez perdu ! Retournez au menu pour recommencer", Toast.LENGTH_LONG).show();
                }else
                {
                    startGame();
                }
            }
            else if(nbLifes >0)
            {
                if (Answer.size()== fullAnswer.size())
                {
                    Settings.setCurrentLightsCount(Settings.getCurrentLightsCount()+1);
                    if (Settings.getCurrentLightsCount()== maxLights +1)
                    {
                        score=(currentWeight * stage)+score;
                        Utils.PrintScore(score, scoreView);
                        stage = stage +1;
                        nbLifes =2;
                        Settings.setCurrentLightsCount(minLights);
                        Settings.setCurrentBlocsCount(Settings.getCurrentBlocsCount()+2);
                        if (Settings.getCurrentBlocsCount()>12)
                        {
                            Toast.makeText(getApplicationContext(), "Vous avez gagné ! Vous êtes forts.. Mode supérieur ?", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            startGame();
                        }
                    }
                    else {
                        startGame();
                    }

                }
            }
        }
}
