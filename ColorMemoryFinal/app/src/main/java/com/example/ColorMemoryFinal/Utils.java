package com.example.ColorMemoryFinal;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import  android.graphics.*;
import  java.util.*;
public class Utils {

    public  static  void offButtons(List<Button> ListButton)
    {
        int myColor = Color.parseColor("#AAAAAA");
        for (Button button: ListButton)
        {
            button.setBackground(new ColorDrawable(myColor));
        }
    }
    public  static  void onButtons(List<Button> ListButton, List<Drawable> ListColor)
    {
        int i=0;
        for (Button button: ListButton)
        {
            button.setBackground(ListColor.get(i));
            i++;
        }
    }
    public  static  void disableButtons(List<Button> ListButton,int nbBloc)
    {
        for (int i=0;i<ListButton.size();i++)
        {
            ListButton.get(i).setVisibility(View.VISIBLE);
        }
        for (int i=nbBloc+1;i<ListButton.size();i++)
        {
            ListButton.get(i).setVisibility(View.INVISIBLE);
        }
    }

    public static Button returnRandomButton(List<Button> ListButton, int currentBlocsCount )
    {
        int min = 0;
        int max = currentBlocsCount;

        Random r = new Random();
        int res = r.nextInt(max - min + 1) + min;

        return  ListButton.get(res);
    }

    public  static  void PrintScore(double score, TextView currentScore)
    {
        currentScore.setText("Votre score s'élève à : "+(score));
    }
    public  static  List<Button> AskQuestion(int currentBlocsCount,List<Button> AllButtons,int nb)
    {
        List<Button> fullAnswer = new ArrayList<Button>();
        for (int i=0;i<nb ;i++)
        {
            fullAnswer.add(returnRandomButton(AllButtons,currentBlocsCount));
        }

        return  fullAnswer;
    }
    public static Drawable RetrieveColor(Button ButtonColorAtrouver,List<Button> CollectOfButton,List<Drawable> CollectOfCollor)
    {
       for (int i=0;i<CollectOfButton.size();i++)
       {
           if (CollectOfButton.get(i)==ButtonColorAtrouver)
           {
               return CollectOfCollor.get(i);
           }
       }
       return  null;
    }

}
