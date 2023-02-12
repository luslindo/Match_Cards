package memMatch;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Card {
    private Image frontImage,backImage;
    private boolean faceUp;
    private String cardName;
    public int row,col;
    public final int width =120;
    public final int height = 160;

    public Card(String name){
        cardName=name;
        faceUp=false;
        try{
            frontImage = ImageIO.read(new File("images/"+name+".gif"));
            backImage = ImageIO.read(new File("images/bg.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setRowCol(int row , int col){
        this.row=row;
        this.col =col;
    }
    public void flip(){
        if(faceUp){
            faceUp=false;
        }
        else{
            faceUp=true;
        }
    }
    public void draw(Graphics g){
        if(faceUp){
            g.drawImage(frontImage,row,col,width,height,null);
        }
        else{
            g.drawImage(backImage,row,col,width,height,null);
        }
    }
    public boolean isSameCard(Card c){
        if(cardName.equals(c.cardName)){
            return true;
        }
        else{
            return false;
        }
    }


}
