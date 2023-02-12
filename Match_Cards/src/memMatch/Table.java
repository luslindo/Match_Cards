package memMatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Table extends JPanel {
    private Card[][]grid ;
    private Card first ;
    private Card second ;

    public Table()  {
        int num=1;

        grid =new  Card[5][4];
        for(int i=0;i<grid.length;i++){
            for (int j = 0; j <grid[i].length ; j++) {
                grid[i][j]= new Card(""+num);
                if(num<11){
                    num++;
                }
                else {
                    num=1;
                }
            }

        }
        shuffle();
        addMouseListener(new FlipCard());
    }
    public void shuffle(){
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                int row = (int)(Math.random()*grid.length);
                int col = (int)(Math.random()*grid[i].length);

                Card a = grid[i][j];
                grid[i][j]=grid[row][col];
                grid[row][col]=a;
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                grid[i][j].setRowCol(i*120,j*160);
                grid[i][j].draw(g);
            }
        }
    }
    class FlipCard implements MouseListener{
        int click =0;
        @Override
        public void mouseClicked(MouseEvent e) {
            click++;
            int row = e.getX()/120;
            int col = e.getY()/160;
            if(click==1){
                first= grid[row][col];
                first.flip();
            }
            else if(click==2){
                second=grid[row][col];
                second.flip();
            }
            else{
                if(!(first.isSameCard(second))){
                    first.flip();
                    second.flip();
                }
                click=0;

            }
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
