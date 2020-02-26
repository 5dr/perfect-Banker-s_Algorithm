/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banker.s_algorithm;

import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author asd
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane p2, p1;

    @FXML
    private Label r0_claim, p0_claim, r0_allocate, p0_allocate, r0_recource;

    @FXML
    private TextField in_0_0_claim, in_0_0_allocate, in_0_recource;
    @FXML
    private Pane p3;

    @FXML
    private Label r0_c_a;

    @FXML
    private Label p0_c_a;

    @FXML
    private TextField in_0_0_c_a;

    @FXML
    private Label r0_avaliable;

    @FXML
    private TextField in_0_avaliable;

    @FXML
    private Label answer;

    private TextField[][] claim;
    private TextField[][] allocate;
    private TextField[][] c;
    private TextField[] resourse;
    private TextField[] avaliable;

    @FXML
    private JFXTextField num_r, num_p;

    int r;
    int p;

    int[][] claim_matrix;
    int[][] allocate_matrix;
    int[][] c_a;
    int[] resource_vector;
    int[] available_vector;

    @FXML
    private void test(ActionEvent event) {
        if (isNumeric(num_r.getText())) {
            if (isNumeric(num_p.getText())) {

                p = Integer.parseInt(num_p.getText());
                r = Integer.parseInt(num_r.getText());
                claim_matrix = new int[p][r];
                claim = new TextField[p][r];
                allocate_matrix = new int[p][r];
                allocate = new TextField[p][r];
                resource_vector = new int[r];
                resourse = new TextField[r];
                c_a = new int[p][r];
                available_vector = new int[r];

                //////////////////start claim matrix//////////////////////
                for (int i = 1; i < r; i++) {
                    Label l = new Label("R" + i);
                    l.setBackground(r0_claim.getBackground());
                    l.setFont(r0_claim.getFont());
                    l.setPrefSize(r0_claim.getPrefWidth(), r0_claim.getPrefHeight());
                    l.setLayoutX(r0_claim.getLayoutX() + r0_claim.getPrefWidth() * i + 2 * i);
                    l.setLayoutY(r0_claim.getLayoutY());
                    l.setTextFill(r0_claim.getTextFill());
                    l.setId("r" + i + "_claim");

                    p2.getChildren().add(l);
                }
                for (int i = 1; i < p; i++) {
                    Label l = new Label("P" + i);
                    l.setBackground(p0_claim.getBackground());
                    l.setFont(p0_claim.getFont());
                    l.setPrefSize(p0_claim.getPrefWidth(), r0_claim.getPrefHeight());
                    l.setLayoutX(p0_claim.getLayoutX());
                    l.setLayoutY(p0_claim.getLayoutY() + r0_claim.getPrefHeight() * i);
                    l.setTextFill(p0_claim.getTextFill());
                    l.setId("p" + i + "_claim");

                    p2.getChildren().add(l);
                }

                for (int i = 0; i < p; i++) {
                    for (int j = 0; j < r; j++) {
                        if (i == 0 && j == 0) {
                            claim[i][j] = in_0_0_claim;
                            continue;
                        }
                        TextField l = new TextField();
                        l.setBackground(in_0_0_claim.getBackground());
                        l.setFont(in_0_0_claim.getFont());
                        l.setPrefSize(in_0_0_claim.getPrefWidth(), in_0_0_claim.getPrefHeight());
                        l.setLayoutX(in_0_0_claim.getLayoutX() + in_0_0_claim.getPrefWidth() * j + 1 * j);
                        l.setLayoutY(in_0_0_claim.getLayoutY() + in_0_0_claim.getPrefHeight() * (i) + 10 * i);
                        l.setId("in_" + i + "_" + j + "_claim");
                        claim[i][j] = l;

                        p2.getChildren().add(l);

                    }
                }
                //////////////////end claim matrix//////////////////////

                //////////////////start Allocate matrix////////////////////// 
                for (int i = 1; i < r; i++) {
                    Label l = new Label("R" + i);
                    l.setBackground(r0_allocate.getBackground());
                    l.setFont(r0_allocate.getFont());
                    l.setPrefSize(r0_allocate.getPrefWidth(), r0_allocate.getPrefHeight());
                    l.setLayoutX(r0_allocate.getLayoutX() + r0_allocate.getPrefWidth() * i + 2 * i);
                    l.setLayoutY(r0_allocate.getLayoutY());
                    l.setTextFill(r0_allocate.getTextFill());
                    l.setId("r" + i + "_allocate");

                    p2.getChildren().add(l);
                }
                for (int i = 1; i < p; i++) {
                    Label l = new Label("P" + i);
                    l.setBackground(p0_allocate.getBackground());
                    l.setFont(p0_allocate.getFont());
                    l.setPrefSize(p0_allocate.getPrefWidth(), p0_allocate.getPrefHeight());
                    l.setLayoutX(p0_allocate.getLayoutX());
                    l.setLayoutY(p0_allocate.getLayoutY() + p0_allocate.getPrefHeight() * i);
                    l.setTextFill(p0_allocate.getTextFill());
                    l.setId("p" + i + "_allocate");

                    p2.getChildren().add(l);
                }

                for (int i = 0; i < p; i++) {

                    for (int j = 0; j < r; j++) {
                        if (i == 0 && j == 0) {
                            allocate[i][j] = in_0_0_allocate;
                            continue;
                        }
                        TextField l = new TextField();
                        l.setBackground(in_0_0_allocate.getBackground());
                        l.setFont(in_0_0_allocate.getFont());
                        l.setPrefSize(in_0_0_allocate.getPrefWidth(), in_0_0_allocate.getPrefHeight());
                        l.setLayoutX(in_0_0_allocate.getLayoutX() + in_0_0_allocate.getPrefWidth() * j + 1 * j);
                        l.setLayoutY(in_0_0_allocate.getLayoutY() + in_0_0_allocate.getPrefHeight() * (i) + 10 * i);
                        l.setId("in_" + i + "_" + j + "_allocate");

                        allocate[i][j] = l;

                        p2.getChildren().add(l);

                    }
                }
                //////////////////end Allocate matrix//////////////////////

                //////////////////start resouece vector//////////////////////
                for (int i = 1; i < r; i++) {
                    Label l = new Label("R" + i);
                    l.setBackground(r0_recource.getBackground());
                    l.setFont(r0_recource.getFont());
                    l.setPrefSize(r0_recource.getPrefWidth(), r0_recource.getPrefHeight());
                    l.setLayoutX(r0_recource.getLayoutX() + r0_recource.getPrefWidth() * i + 2 * i);
                    l.setLayoutY(r0_recource.getLayoutY());
                    l.setTextFill(r0_recource.getTextFill());
                    l.setId("r" + i + "_recource");

                    p2.getChildren().add(l);
                }

                for (int j = 0; j < r; j++) {
                    if (j == 0) {
                        resourse[j] = in_0_recource;
                        continue;
                    }
                    TextField l = new TextField();
                    l.setBackground(in_0_recource.getBackground());
                    l.setFont(in_0_recource.getFont());
                    l.setPrefSize(in_0_recource.getPrefWidth(), in_0_recource.getPrefHeight());
                    l.setLayoutX(in_0_recource.getLayoutX() + in_0_recource.getPrefWidth() * j + 1 * j);
                    l.setLayoutY(in_0_recource.getLayoutY());
                    l.setId("in_" + j + "_claim");
                    resourse[j] = l;

                    p2.getChildren().add(l);

                }
                //////////////////End resouece vector//////////////////////

                p1.setVisible(false);
                p3.setVisible(false);
                p2.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "please enter intger number in Process");
            }
        } else {

            JOptionPane.showMessageDialog(null, "please enter intger number in Resouese");
        }

    }

    @FXML
    private void collecte(ActionEvent event) {

        ///////////////full claim matrix////////////////
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {

                claim_matrix[i][j] = Integer.parseInt(claim[i][j].getText());

            }
        }
        ///////////////full allocate matrix////////////////
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {

                allocate_matrix[i][j] = Integer.parseInt(allocate[i][j].getText());

            }
        }

        ///////////////full resource_vector matrix////////////////
        for (int j = 0; j < r; j++) {

            resource_vector[j] = Integer.parseInt(resourse[j].getText());

        }

        ///////////////full c-a matrix////////////////
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {

                c_a[i][j] = claim_matrix[i][j] - allocate_matrix[i][j];

            }
        }

        ///////////////full available matrix////////////////
        for (int i = 0; i < r; i++) {
            int x = 0;
            for (int j = 0; j < p; j++) {
                x += allocate_matrix[j][i];
                System.out.println(x);

            }
            available_vector[i] = resource_vector[i] - x;

        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {

                System.out.println(claim_matrix[i][j]);

            }
        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {

                System.out.println(allocate_matrix[i][j]);

            }
        }

        for (int j = 0; j < r; j++) {

            System.out.println(resource_vector[j]);

        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {

                System.out.println(c_a[i][j]);

            }
        }

        for (int j = 0; j < r; j++) {

            System.out.println(available_vector[j]);

        }
        
        //////////////////start c-a matrix//////////////////////
                for (int i = 1; i < r; i++) {
                    Label l = new Label("R" + i);
                    l.setBackground(r0_c_a.getBackground());
                    l.setFont(r0_c_a.getFont());
                    l.setPrefSize(r0_c_a.getPrefWidth(), r0_c_a.getPrefHeight());
                    l.setLayoutX(r0_c_a.getLayoutX() + r0_c_a.getPrefWidth() * i + 2 * i);
                    l.setLayoutY(r0_c_a.getLayoutY());
                    l.setTextFill(r0_c_a.getTextFill());

                    p3.getChildren().add(l);
                }
                for (int i = 1; i < p; i++) {
                    Label l = new Label("P" + i);
                    l.setBackground(p0_c_a.getBackground());
                    l.setFont(p0_c_a.getFont());
                    l.setPrefSize(p0_c_a.getPrefWidth(), p0_c_a.getPrefHeight());
                    l.setLayoutX(p0_c_a.getLayoutX());
                    l.setLayoutY(p0_c_a.getLayoutY() + p0_c_a.getPrefHeight() * i);
                    l.setTextFill(p0_c_a.getTextFill());

                    p3.getChildren().add(l);
                }

                for (int i = 0; i < p; i++) {
                    for (int j = 0; j < r; j++) {
                        if (i == 0 && j == 0) {
                           in_0_0_c_a.setText(String.valueOf(c_a[i][j]));
                            continue;
                        }
                        TextField l = new TextField();
                        l.setBackground(in_0_0_c_a.getBackground());
                        l.setFont(in_0_0_c_a.getFont());
                        l.setPrefSize(in_0_0_c_a.getPrefWidth(), in_0_0_c_a.getPrefHeight());
                        l.setLayoutX(in_0_0_c_a.getLayoutX() + in_0_0_c_a.getPrefWidth() * j + 1 * j);
                        l.setLayoutY(in_0_0_c_a.getLayoutY() + in_0_0_c_a.getPrefHeight() * (i) + 10 * i);
                        l.setDisable(true);
                        //c[i][j] = l;
                        l.setText(String.valueOf(c_a[i][j]));

                        p3.getChildren().add(l);

                    }
                }
                
                //////////////////start available vector//////////////////////

                for (int i = 1; i < r; i++) {
                    Label l = new Label("R" + i);
                    l.setBackground(r0_avaliable.getBackground());
                    l.setFont(r0_avaliable.getFont());
                    l.setPrefSize(r0_avaliable.getPrefWidth(), r0_avaliable.getPrefHeight());
                    l.setLayoutX(r0_avaliable.getLayoutX() + r0_avaliable.getPrefWidth() * i + 2 * i);
                    l.setLayoutY(r0_avaliable.getLayoutY());
                    l.setTextFill(r0_avaliable.getTextFill());
                    
                    p3.getChildren().add(l);
                }

                for (int j = 0; j < r; j++) {
                    if (j == 0) {
                   in_0_avaliable.setText(String.valueOf(available_vector[j]));
                        continue;
                    }
                    TextField l = new TextField();
                    l.setBackground(in_0_avaliable.getBackground());
                    l.setFont(in_0_avaliable.getFont());
                    l.setPrefSize(in_0_avaliable.getPrefWidth(), in_0_avaliable.getPrefHeight());
                    l.setLayoutX(in_0_avaliable.getLayoutX() + in_0_avaliable.getPrefWidth() * j + 1 * j);
                    l.setLayoutY(in_0_avaliable.getLayoutY());
                    l.setDisable(true);
                    l.setText(String.valueOf(available_vector[j]));

                    p3.getChildren().add(l);

                }
                //////////////////End available vector//////////////////////
        
        if(!isSafe()){
            if(status=="res"){
            answer.setText("System not Safe because resouce not enough");
            System.out.println("System not Safe because resouce not enough");
            }else if(status=="un")
            answer.setText("System not Safe because you have deadlock");
      System.out.println("System not Safe because you have deadlock");
                    }else{
         answer.setText("System is Safe and seq is p :");
         for(int i=0;i<r;i++){
         String s=answer.getText();
         s+=" , "+z[i];
        answer.setText(s);
         }
         
            System.out.println("System is Safe");
        
        }

        p1.setVisible(false);
        p3.setVisible(true);
        p2.setVisible(false);
    }

    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
    String status;
    int z[];
    private boolean isSafe(){
    
        for(int i=0;i<p;i++){
          for(int j=0;j<r;j++){
          if(claim_matrix[i][j]>resource_vector[j]){
          status="res";
          return false;
          }
          }
        }
       
        int time=0;
        int cou=0;
        z=new int[r];
     
        for(int i=0;i<r;i++){
         
            if(!check_zero(i)){
                if(comp(i)){
                    zero(i);
                    System.out.println(i);
                   for (int j = 0; j < r; j++) {

            System.out.println(available_vector[j]);

        }
                   z[cou++]=i;
                    i=-1;
                    time++;
                    System.out.println(time);
                }
            }
          
        }
        if(time==r)return true;
        
        else{status="un";  return false;}
    
    
    }

    private boolean check_zero(int x){
        System.out.println("chech_zero"+x);
        
        int y=0;
    for(int i=0;i<r;i++){
        if(c_a[x][i]==0){
        y++;
            System.out.println("y= "+y);
        }}
    if(y==r)return true;
            
      else  return false;
    
    
    }
    
    private void zero(int x){
        System.out.println("zero"+x);
    for(int i=0;i<r;i++){
        available_vector[i]+=allocate_matrix[x][i];
        }
    for(int i=0;i<r;i++){
        c_a[x][i]=0;
        allocate_matrix[x][i]=0;
        claim_matrix[x][i]=0;
        }
 //  z[co]=x;
  // co++;
    }
    private boolean comp(int x){
        System.out.println("comp"+x);
       int y=0;
       int i;
    for( i=0;i<r;i++){
        System.out.println("c_a[x][i]"+c_a[x][i]+"  available_vector[i]"+available_vector[i]);
       if(c_a[x][i]<=available_vector[i]){
       y++;
       }
    
    }
    if(y==i)return true;
    
   else  return false;
    } 
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
