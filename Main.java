package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

	public void start(Stage primaryStage) {
		DecimalFormat df=new DecimalFormat("#,###");
		DecimalFormat df1=new DecimalFormat("###,##0.0");
		String line = System.getProperty("line.separator");

	    primaryStage.setTitle("総金額計算機");

	    GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25,25,25,25));
	    grid.getColumnConstraints().add(new ColumnConstraints(50));
	    grid.getColumnConstraints().add(new ColumnConstraints(100));
	    grid.getColumnConstraints().add(new ColumnConstraints(100));
	    final Separator sepVert1 = new Separator();
        grid.add(sepVert1, 0, 1, 4, 1);
	    final Separator sepVert2 = new Separator();
        grid.add(sepVert2, 0, 9, 4, 9);

	    Scene scene = new Scene(grid, 400, 600);
	    primaryStage.setScene(scene);
	    scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());

	    Text Abstract = new Text("摘要");
	    grid.add(Abstract, 0 , 0);
	    Text Amount = new Text("単価");
	    grid.add(Amount, 1 , 0);

	    Button Hensyu = new Button("編集");
	    HBox hbHensyu = new HBox(10);
	    hbHensyu.setAlignment(Pos.BOTTOM_RIGHT);
	    hbHensyu.setMinWidth(80.0);
	    hbHensyu.setPrefWidth(80.0);
	    hbHensyu.setMaxWidth(80.0);
	    hbHensyu.getChildren().add(Hensyu);
	    grid.add(hbHensyu, 1, 0);

	    Text Price = new Text("数量");
	    grid.add(Price, 2 , 0);
	    Text Total = new Text("単種合計");
	    grid.add(Total, 3 , 0);

	    Label A = new Label("A");
	    grid.add(A, 0, 2);
	    TextField AAmount = new TextField();
	    //AAmount.setText("1000");
	    AAmount.setEditable(false);
	    AAmount.setMouseTransparent(true);
	    AAmount.setFocusTraversable(false);
	    AAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(AAmount, 1, 2);
	    TextField APrice = new TextField();
	    APrice.setText("1.5");
	    APrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(APrice, 2, 2);
	    TextField ATotal = new TextField();
	    ATotal.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ATotal, 3, 2);

	    Label B = new Label("B");
	    grid.add(B, 0, 3);
	    TextField BAmount = new TextField();
	    //BAmount.setText("2000");
	    BAmount.setEditable(false);
	    BAmount.setMouseTransparent(true);
	    BAmount.setFocusTraversable(false);
	    BAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(BAmount, 1, 3);
	    TextField BPrice = new TextField();
	    BPrice.setText("2.4");
	    BPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(BPrice, 2, 3);
	    TextField BTotal = new TextField();
	    BTotal.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(BTotal, 3, 3);

	    Label C = new Label("C");
	    grid.add(C, 0, 4);
	    TextField CAmount = new TextField();
	    //CAmount.setText("500");
	    CAmount.setEditable(false);
	    CAmount.setMouseTransparent(true);
	    CAmount.setFocusTraversable(false);
	    CAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(CAmount, 1, 4);
	    TextField CPrice = new TextField();
	    CPrice.setText("3.0");
	    CPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(CPrice, 2, 4);
	    TextField CTotal = new TextField();
	    CTotal.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(CTotal, 3, 4);

	    Label D = new Label("D");
	    grid.add(D, 0, 5);
	    TextField DAmount = new TextField();
	    //DAmount.setText("1000");
	    DAmount.setEditable(false);
	    DAmount.setMouseTransparent(true);
	    DAmount.setFocusTraversable(false);
	    DAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(DAmount, 1, 5);
	    TextField DPrice = new TextField();
	    DPrice.setText("2.0");
	    DPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(DPrice, 2, 5);
	    TextField DTotal = new TextField();
	    DTotal.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(DTotal, 3, 5);

	    Label E = new Label("E");
	    grid.add(E, 0, 6);
	    TextField EAmount = new TextField();
	    //EAmount.setText("600");
	    EAmount.setEditable(false);
	    EAmount.setMouseTransparent(true);
	    EAmount.setFocusTraversable(false);
	    EAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(EAmount, 1, 6);
	    TextField EPrice = new TextField();
	    EPrice.setText("1.0");
	    EPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(EPrice, 2, 6);
	    TextField ETotal = new TextField();
	    ETotal.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ETotal, 3, 6);

	    Label Syoukei = new Label("小計");
	    grid.add(Syoukei, 0, 7);
	    TextField SyoukeiAmount = new TextField();
	    SyoukeiAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(SyoukeiAmount, 1, 7);
	    TextField SyoukeiPrice = new TextField();
	    SyoukeiPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(SyoukeiPrice, 3, 7);

	    Label Tesuuryou = new Label("手数料");
	    grid.add(Tesuuryou, 0, 8);
	    TextField Percentage = new TextField();
	    Percentage.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(Percentage, 1, 8);
	    Percentage.setText("0.1");
	    Label Plus = new Label("                     +");
	    grid.add(Plus, 2, 8);
	    TextField TesuuryouPrice = new TextField();
	    TesuuryouPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(TesuuryouPrice, 3, 8);

	    Label Nebiki = new Label("値引き");
	    grid.add(Nebiki, 0, 9);
	    TextField NebikiPrice = new TextField();
	    NebikiPrice.setAlignment(Pos.CENTER_RIGHT);
	    NebikiPrice.setText("-0%");
	    grid.add(NebikiPrice, 2, 9);
	    TextField NebikiPriceMinus = new TextField();
	    NebikiPriceMinus.setAlignment(Pos.CENTER_RIGHT);
	    NebikiPriceMinus.setText("-0");
	    grid.add(NebikiPriceMinus, 3, 9);

	    Label Kei = new Label("計");
	    grid.add(Kei, 0, 10);
	    TextField KeiPrice = new TextField();
	    KeiPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(KeiPrice, 3, 10);
	    Label Mutiple = new Label("                     *");
	    grid.add(Mutiple, 2, 10);

	    Label Syouhizei = new Label("消費税");
	    grid.add(Syouhizei, 0, 11);
	    TextField SyouhizeiPercentage = new TextField();
	    SyouhizeiPercentage.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(SyouhizeiPercentage, 1, 11);
	    SyouhizeiPercentage.setText("0.08");
	    Label Plus1 = new Label("                     +");
	    grid.add(Plus1, 2, 11);
	    TextField SyouhizeiPrice = new TextField();
	    SyouhizeiPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(SyouhizeiPrice, 3, 11);

	    Label Goukei = new Label("合計");
	    grid.add(Goukei, 0, 13);
	    TextField GoukeiPrice = new TextField();
	    GoukeiPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(GoukeiPrice, 3, 13);


	    Button Keisan = new Button("計算");
	    HBox hbKeisan = new HBox(10);
	    hbKeisan.setAlignment(Pos.BOTTOM_CENTER);
	    hbKeisan.setMinWidth(80.0);
	    hbKeisan.setPrefWidth(80.0);
	    hbKeisan.setMaxWidth(80.0);
	    hbKeisan.getChildren().add(Keisan);
	    grid.add(hbKeisan, 2, 15);

	    Button Tojiru = new Button("閉じる");
	    HBox hbTojiru = new HBox(10);
	    hbTojiru.setAlignment(Pos.BOTTOM_CENTER);
	    hbTojiru.setMinWidth(80.0);
	    hbTojiru.setPrefWidth(80.0);
	    hbTojiru.setMaxWidth(80.0);
	    hbTojiru.getChildren().add(Tojiru);
	    grid.add(hbTojiru, 3, 15);

	    Button Hiraku = new Button("開く");
	    HBox hbHiraku= new HBox(10);
	    hbHiraku.setAlignment(Pos.BOTTOM_CENTER);
	    hbHiraku.setMinWidth(80.0);
	    hbHiraku.setPrefWidth(80.0);
	    hbHiraku.setMaxWidth(80.0);
	    hbHiraku.getChildren().add(Hiraku);
	    grid.add(hbHiraku, 0, 15);

	    Button Hozon = new Button("保存");
	    HBox hbHozon = new HBox(10);
	    hbHozon.setAlignment(Pos.BOTTOM_CENTER);
	    hbHozon.setMinWidth(80.0);
	    hbHozon.setPrefWidth(80.0);
	    hbHozon.setMaxWidth(80.0);
	    hbHozon.getChildren().add(Hozon);
	    grid.add(hbHozon, 1, 15);

	    final TextField ShowSyoukeiAmount = new TextField();
	    ShowSyoukeiAmount.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowSyoukeiAmount, 1, 7);
	    final TextField ShowSyoukeiPrice= new TextField();
	    ShowSyoukeiPrice.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowSyoukeiPrice, 3, 7);

	    final TextField ShowTessuryou = new TextField();
	    ShowTessuryou.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowTessuryou, 3, 8);

	    final TextField ShowNebikiPriceMinus = new TextField();
	    ShowNebikiPriceMinus.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowNebikiPriceMinus, 3, 9);

	    final Text NebikiSet = new Text();
	    grid.add(NebikiSet, 2, 9);

	    final TextField ShowKei = new TextField();
	    ShowKei.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowKei, 3, 10);

	    final TextField ShowSyouhizei = new TextField();
	    ShowSyouhizei.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowSyouhizei, 3, 11);

	    final TextField ShowGoukei = new TextField();
	    ShowGoukei.setAlignment(Pos.CENTER_RIGHT);
	    grid.add(ShowGoukei, 3, 13);

	    Text ShowError = new Text("ファイルを読み込んでください");
	    grid.add(ShowError, 0, 16);

	    StringBuffer OutputFile = new StringBuffer("摘要\t単価\t数量\t単種合計");
	    OutputFile.append(line);


	    Keisan.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent e) {


	        	  AAmount.setText(AAmount.getText().replace(",",""));
	        	  BAmount.setText(BAmount.getText().replace(",",""));
	        	  CAmount.setText(CAmount.getText().replace(",",""));
	        	  DAmount.setText(DAmount.getText().replace(",",""));
	        	  EAmount.setText(EAmount.getText().replace(",",""));


	        	  NebikiPrice.setText(NebikiPrice.getText().replace("%",""));
	        	  NebikiPrice.setText(NebikiPrice.getText().replace("-",""));

	        	  Double SyoukeiAmount = 0.0;

	        	  String[] AmountCheck = new String[5];
	        	  AmountCheck[0] = AAmount.getText().replace(",","");
	        	  AmountCheck[1] = BAmount.getText().replace(",","");
	        	  AmountCheck[2] = CAmount.getText().replace(",","");
	        	  AmountCheck[3] = DAmount.getText().replace(",","");
	        	  AmountCheck[4] = EAmount.getText().replace(",","");
	        	  if( isInteger( AmountCheck ) ) {
	        		  for( int i = 0; i < AmountCheck.length; i++){
	        			  SyoukeiAmount += Double.parseDouble(AmountCheck[i]);
	        		  }
	        	  }

	        	  Double CaculateResult = 0.0;
	        	  String[] PriceCheck = new String[5];
	        	  PriceCheck[0] = APrice.getText().replace(",","");
	        	  PriceCheck[1] = BPrice.getText().replace(",","");
	        	  PriceCheck[2] = CPrice.getText().replace(",","");
	        	  PriceCheck[3] = DPrice.getText().replace(",","");
	        	  PriceCheck[4] = EPrice.getText().replace(",","");
	        	  if( isNumber( PriceCheck ) ) {
	        		  ShowError.setText("数量チェック済み");
	        		  for(int i = 0; i < PriceCheck.length; i++){
	        			  CaculateResult += Double.parseDouble( PriceCheck[i] ) * Double.parseDouble( AmountCheck[i] );
	        		  }
	        	  } else {
	        		  ShowError.setText("正しい数量を入力してください");
	        	  }


	        	  ShowSyoukeiAmount.setText("  "+df.format(SyoukeiAmount));
	        	  ShowSyoukeiPrice.setText("  "+df.format(CaculateResult));

	        	  Double CalculateTesuuryou = Double.parseDouble(Percentage.getText()) * CaculateResult;
	        	  ShowTessuryou.setText("  "+df.format(CalculateTesuuryou));

	        	  Double CalculateKei = (CaculateResult + CalculateTesuuryou )* (1-Double.parseDouble(NebikiPrice.getText())/100);
	        	  ShowKei.setText("  "+df.format(CalculateKei));
	        	  Double CalNebikiPriceMinus = (CaculateResult + CalculateTesuuryou )* (Double.parseDouble(NebikiPrice.getText())/100);
	        	  ShowNebikiPriceMinus.setText("-"+df.format(CalNebikiPriceMinus));


	        	  Double CalculateSyouhizei = CalculateKei * Double.parseDouble(SyouhizeiPercentage.getText());
	        	  ShowSyouhizei.setText("  "+df.format(CalculateSyouhizei));

	        	  Double CalculateGoukei = CalculateKei + CalculateSyouhizei;
	        	  ShowGoukei.setText("  " + df.format(CalculateGoukei));

	      	      OutputFile.append("A\t" + df.format( Double.parseDouble(AAmount.getText() ) ) + "\t"+ df1.format( Double.parseDouble(APrice.getText() ) )+ "\t"+ df.format( Double.parseDouble(AAmount.getText()) * Double.parseDouble(APrice.getText())) );
	      	      OutputFile.append(line);
	      	      OutputFile.append("B\t" + df.format( Double.parseDouble(BAmount.getText() ) ) + "\t"+ df1.format( Double.parseDouble(BPrice.getText() ) )+ "\t"+ df.format( Double.parseDouble(BAmount.getText()) * Double.parseDouble(BPrice.getText())) );
	      	      OutputFile.append(line);
	      	      OutputFile.append("C\t" + df.format( Double.parseDouble(CAmount.getText() ) ) + "\t"+ df1.format( Double.parseDouble(CPrice.getText() ) )+ "\t"+ df.format( Double.parseDouble(CAmount.getText()) * Double.parseDouble(CPrice.getText())) );
	      	      OutputFile.append(line);
	      	      OutputFile.append("D\t" + df.format( Double.parseDouble(DAmount.getText() ) ) + "\t"+ df1.format( Double.parseDouble(DPrice.getText() ) )+ "\t"+ df.format( Double.parseDouble(DAmount.getText()) * Double.parseDouble(DPrice.getText())) );
	      	      OutputFile.append(line);
	      	      OutputFile.append("E\t" + df.format( Double.parseDouble(EAmount.getText() ) ) + "\t"+ df1.format( Double.parseDouble(EPrice.getText() ) )+ "\t"+ df.format( Double.parseDouble(EAmount.getText()) * Double.parseDouble(EPrice.getText())) );
	      	      OutputFile.append(line);

	      	      OutputFile.append("小計\t" + df.format(SyoukeiAmount) + "\t\t" + df.format(CaculateResult));
	      	      OutputFile.append(line);
	      	      OutputFile.append("手数料\t" + df1.format(Double.parseDouble(Percentage.getText())) + "\t\t" + df.format(CalculateTesuuryou));
	      	      OutputFile.append(line);
	      	      OutputFile.append("値引き\t\t" + "-" + NebikiPrice.getText() + "%\t"  + "-"+df.format(CalNebikiPriceMinus));
	      	      OutputFile.append(line);
	      	      OutputFile.append("計\t\t\t" + df.format(CalculateKei));
	      	      OutputFile.append(line);
	      	      OutputFile.append("消費税\t" + df1.format(Double.parseDouble(SyouhizeiPercentage.getText())) + "\t\t" + df.format(CalculateSyouhizei));
	      	      OutputFile.append(line);
	      	      OutputFile.append("計\t\t\t" + df.format(CalculateKei));
	      	      OutputFile.append(line);

	        	  ATotal.setText("" + df.format( Double.parseDouble(AAmount.getText()) * Double.parseDouble(APrice.getText())));
	        	  BTotal.setText("" + df.format( Double.parseDouble(BAmount.getText()) * Double.parseDouble(BPrice.getText())));
	        	  CTotal.setText("" + df.format( Double.parseDouble(CAmount.getText()) * Double.parseDouble(CPrice.getText())));
	        	  DTotal.setText("" + df.format( Double.parseDouble(DAmount.getText()) * Double.parseDouble(DPrice.getText())));
	        	  ETotal.setText("" + df.format( Double.parseDouble(EAmount.getText()) * Double.parseDouble(EPrice.getText())));


	        	  AAmount.setText("" + df.format( Double.parseDouble(AAmount.getText() ) ));
	        	  BAmount.setText("" + df.format( Double.parseDouble(BAmount.getText() ) ));
	        	  CAmount.setText("" + df.format( Double.parseDouble(CAmount.getText() ) ));
	        	  DAmount.setText("" + df.format( Double.parseDouble(DAmount.getText() ) ));
	        	  EAmount.setText("" + df.format( Double.parseDouble(EAmount.getText() ) ));

	        	  APrice.setText("" + df1.format( Double.parseDouble(APrice.getText() ) ));
	        	  BPrice.setText("" + df1.format( Double.parseDouble(BPrice.getText() ) ));
	        	  CPrice.setText("" + df1.format( Double.parseDouble(CPrice.getText() ) ));
	        	  DPrice.setText("" + df1.format( Double.parseDouble(DPrice.getText() ) ));
	        	  EPrice.setText("" + df1.format( Double.parseDouble(EPrice.getText() ) ));



	        	  NebikiPrice.setText("-" + NebikiPrice.getText() + "%");

	          }
	       });
	    Tojiru.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent ae){
	    		primaryStage.close();
	    	}
	    });

	    StringBuffer Resoures = new StringBuffer("");
	    Hiraku.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent ae){
	    		JFileChooser fd = new JFileChooser();
                Resoures.append( fd.getSelectedFile() );
	    		fd.showOpenDialog(null);
	            try (
	            		InputStreamReader read = new InputStreamReader(new FileInputStream( fd.getSelectedFile() ), "UTF-8");
	            		BufferedReader bufferedReader = new BufferedReader(read);
	            ){
	                String lineTxt = null;

	                HashMap<String, String> InputData = new HashMap<String, String>();
	                while ((lineTxt = bufferedReader.readLine()) != null)
	                {
	                	String lineTxtReplace = lineTxt.replace(",", "");
	                    String[] Array = lineTxtReplace.split("=");
	                    InputData.put(Array[0], Array[1]);
	                }
	                AAmount.setText("" + df.format( Double.parseDouble(InputData.get("A") ) ));
	                BAmount.setText("" + df.format( Double.parseDouble(InputData.get("B") ) ));
	                CAmount.setText("" + df.format( Double.parseDouble(InputData.get("C") ) ));
	                DAmount.setText("" + df.format( Double.parseDouble(InputData.get("D") ) ));
	                EAmount.setText("" + df.format( Double.parseDouble(InputData.get("E") ) ));

	                ShowError.setText("ファイル読み込み成功、計算ボタンを押してください");
	            }
	            catch (Exception e)
	            {
	            	ShowError.setText("ファイル読み込みエラー");
	                e.printStackTrace();
	            }

	    	}
	    });

	    Hozon.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent ae){
	            JFileChooser jf = new JFileChooser();
	            jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
	            jf.showDialog(null,null);
	            File fi = jf.getSelectedFile();
	            SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd_HHmmss");

	            String f = fi.getAbsolutePath()+"\\"+dfDate.format(new Date())+".txt";
	            System.out.println("save: "+f);

	            try(
                	FileOutputStream fo = new FileOutputStream(f);
	            	OutputStreamWriter out = new OutputStreamWriter(fo, "UTF-8");
	            ){
	                out.write(OutputFile.toString());
	                OutputFile.setLength(0);
	                OutputFile.append("摘要\t単価\t数量\t単種合計");
	                OutputFile.append(line);
	            }
	            catch(Exception e){
	                System.out.println("ファイル保存エラー");
	                e.printStackTrace();
	            }
	    	}
	    });

	    //Open a new window for editing
	    Hensyu.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent ae){
	    		Stage secondWindow=new Stage();
	    		GridPane grid2 = new GridPane();
	    		Scene scene2=new Scene(grid2,300,275);
	    		scene2.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());

	    		grid2.setAlignment(Pos.CENTER);
	    	    grid2.setHgap(10);
	    	    grid2.setVgap(10);
	    	    grid2.setPadding(new Insets(25,25,25,25));
	    	    grid2.getColumnConstraints().add(new ColumnConstraints(50));
	    	    grid2.getColumnConstraints().add(new ColumnConstraints(100));
	    	    grid2.getColumnConstraints().add(new ColumnConstraints(100));

	    	    Label A2 = new Label("A");
	    	    grid2.add(A2, 0, 0);
	    	    TextField AAmount2 = new TextField();
	    	    AAmount2.setAlignment(Pos.CENTER_RIGHT);
	    	    AAmount2.setText(AAmount.getText());
	    	    grid2.add(AAmount2, 1, 0);

	    	    Label B2 = new Label("B");
	    	    grid2.add(B2, 0, 1);
	    	    TextField BAmount2 = new TextField();
	    	    BAmount2.setAlignment(Pos.CENTER_RIGHT);
	    	    BAmount2.setText(BAmount.getText());
	    	    grid2.add(BAmount2, 1, 1);

	    	    Label C2 = new Label("C");
	    	    grid2.add(C2, 0, 2);
	    	    TextField CAmount2 = new TextField();
	    	    CAmount2.setAlignment(Pos.CENTER_RIGHT);
	    	    CAmount2.setText(CAmount.getText());
	    	    grid2.add(CAmount2, 1, 2);

	    	    Label D2 = new Label("D");
	    	    grid2.add(D2, 0, 3);
	    	    TextField DAmount2 = new TextField();
	    	    DAmount2.setAlignment(Pos.CENTER_RIGHT);
	    	    DAmount2.setText(DAmount.getText());
	    	    grid2.add(DAmount2, 1, 3);

	    	    Label E2 = new Label("E");
	    	    grid2.add(E2, 0, 4);
	    	    TextField EAmount2 = new TextField();
	    	    EAmount2.setAlignment(Pos.CENTER_RIGHT);
	    	    EAmount2.setText(EAmount.getText());
	    	    grid2.add(EAmount2, 1, 4);

	    	    Text Message = new Text("数値を入力した後、更新ボタンを押してください");
	    	    grid2.add(Message, 0, 6);


	    	    Button Koushin = new Button("更新");
	    	    HBox hbKoushin = new HBox(10);
	    	    hbKoushin.setAlignment(Pos.BOTTOM_CENTER);
	    	    hbKoushin.setMinWidth(80.0);
	    	    hbKoushin.setPrefWidth(80.0);
	    	    hbKoushin.setMaxWidth(80.0);
	    	    hbKoushin.getChildren().add(Koushin);
	    	    grid2.add(hbKoushin, 2, 2);

	    	    Koushin.setOnAction(new EventHandler<ActionEvent>(){
	    	    	public void handle(ActionEvent ae){
	    	    		String[] AfterEdit = new String[5];
	    	    		AfterEdit[0] = AAmount2.getText().replace(",","");
	    	    		AfterEdit[1] = BAmount2.getText().replace(",","");
	    	    		AfterEdit[2] = CAmount2.getText().replace(",","");
	    	    		AfterEdit[3] = DAmount2.getText().replace(",","");
	    	    		AfterEdit[4] = EAmount2.getText().replace(",","");

	    	    		if( isInteger( AfterEdit )) {
		    	    		AAmount.setText(df.format(Double.parseDouble( AfterEdit[0] )));
		    	    		BAmount.setText(df.format(Double.parseDouble( AfterEdit[1] )));
		    	    		CAmount.setText(df.format(Double.parseDouble( AfterEdit[2] )));
		    	    		DAmount.setText(df.format(Double.parseDouble( AfterEdit[3] )));
		    	    		EAmount.setText(df.format(Double.parseDouble( AfterEdit[4] )));

		    	    		secondWindow.close();
	    	    		} else {
	    	    			Message.setText("入力した数値が正しくない");
	    	    		}
	    	    	}
	    	    });

	    		secondWindow.setTitle("単価編集");
	    		secondWindow.setScene(scene2);
	    		secondWindow.show();
	    	}
	    });
	    primaryStage.setResizable(false);
	    primaryStage.show();
	}

	//Number check
	public static boolean isInteger(String[] str) {
	    Pattern pattern = Pattern.compile("^[\\d]*$");
	    boolean check = true;
	    for( int i = 0; i < str.length; i++){
	    	if( !pattern.matcher(str[i]).matches() ){
	    		check = false;
	    	}
	    }
	    return check;
	}

	public static boolean isNumber(String[] str) {
	    Pattern pattern = Pattern.compile("^([1-9][0-9]*|0)(.[0-9]+)?$");
	    boolean check = true;
	    for( int i = 0; i < str.length; i++){
	    	if( !pattern.matcher(str[i]).matches() ){
	    		check = false;
	    	}
	    }
	    return check;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
