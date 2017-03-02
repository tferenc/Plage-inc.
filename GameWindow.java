import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;

import game.GameTable;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GameWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	GameTable table;
	boolean isNewTurn = true;
	
	public void setTable(GameTable table){
		this.table = table;
	}

	
	public static void main(String[] args) {
		try {
			GameWindow window = new GameWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button button_2 = new Button(shell, SWT.RADIO);
		button_2.setBounds(211, 197, 13, 16);
		
		Button button = new Button(shell, SWT.RADIO);
		button.setBounds(211, 154, 13, 16);
		
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setBounds(211, 113, 13, 16);
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(255, 204, 102));
		canvas.setBounds(10, 62, 123, 189);
		
		CLabel player1CardName = new CLabel(canvas, SWT.NONE);
		player1CardName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		player1CardName.setBackground(SWTResourceManager.getColor(255, 102, 51));
		player1CardName.setAlignment(SWT.CENTER);
		player1CardName.setBounds(10, 10, 103, 21);
		player1CardName.setText(table.getCurrentPlayer().getHand().getTopCard().getName());
		
		Label lblHallozsiArny = new Label(canvas, SWT.NONE);
		lblHallozsiArny.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblHallozsiArny.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblHallozsiArny.setAlignment(SWT.CENTER);
		lblHallozsiArny.setBounds(10, 49, 103, 15);
		lblHallozsiArny.setText("Halálozási arány");
		
		Label lblldozatok = new Label(canvas, SWT.NONE);
		lblldozatok.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblldozatok.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblldozatok.setAlignment(SWT.CENTER);
		lblldozatok.setText("Áldozatok");
		lblldozatok.setBounds(10, 91, 103, 15);
		
		Label lblLappangs = new Label(canvas, SWT.NONE);
		lblLappangs.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblLappangs.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lblLappangs.setAlignment(SWT.CENTER);
		lblLappangs.setText("Lappangás");
		lblLappangs.setBounds(10, 133, 103, 15);
		
		CLabel halalozasiLabel = new CLabel(canvas, SWT.NONE);
		halalozasiLabel.setBackground(SWTResourceManager.getColor(255, 204, 102));
		halalozasiLabel.setAlignment(SWT.CENTER);
		halalozasiLabel.setBounds(31, 70, 61, 15);
		halalozasiLabel.setText(String.valueOf(table.getCurrentPlayer().getHand().getTopCard().getLethality()) + "%");
		
		CLabel aldozatokLabel = new CLabel(canvas, SWT.NONE);
		aldozatokLabel.setBackground(SWTResourceManager.getColor(255, 204, 102));
		aldozatokLabel.setAlignment(SWT.CENTER);
		aldozatokLabel.setText(String.valueOf(table.getCurrentPlayer().getHand().getTopCard().getVictims()) + "/100k");
		aldozatokLabel.setBounds(10, 112, 103, 15);
		
		CLabel lappangasLabel = new CLabel(canvas, SWT.NONE);
		lappangasLabel.setBackground(SWTResourceManager.getColor(255, 204, 102));
		lappangasLabel.setAlignment(SWT.CENTER);
		lappangasLabel.setText(String.valueOf(table.getCurrentPlayer().getHand().getTopCard().getIncubationTime()) + "nap");
		lappangasLabel.setBounds(10, 154, 103, 15);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 49, 414, 0);
		
		Label currentPlayerLabel = new Label(shell, SWT.NONE);
		currentPlayerLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		currentPlayerLabel.setBounds(14, 16, 119, 27);
		currentPlayerLabel.setText("Jelenlegi játékos:");
		
		Label currentPlayer = new Label(shell, SWT.NONE);
		currentPlayer.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		currentPlayer.setBounds(137, 15, 262, 25);
		currentPlayer.setText(table.getCurrentPlayer().getName());
		
		Label lblVlaszdKiA = new Label(shell, SWT.NONE);
		lblVlaszdKiA.setBounds(174, 63, 96, 15);
		lblVlaszdKiA.setText("Válaszd ki a statot");
		
		Button btnKivlaszt = new Button(shell, SWT.NONE);
		
		btnKivlaszt.setBounds(181, 226, 75, 25);
		btnKivlaszt.setText("Kiválaszt!");
		
		Canvas canvas_1 = new Canvas(shell, SWT.NONE);
		canvas_1.setBackground(SWTResourceManager.getColor(255, 204, 102));
		canvas_1.setBounds(301, 62, 123, 189);
		
		CLabel player2CardName = new CLabel(canvas_1, SWT.NONE);
		player2CardName.setVisible(false);
		player2CardName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		player2CardName.setBackground(SWTResourceManager.getColor(255, 102, 51));
		player2CardName.setText((String) null);
		player2CardName.setAlignment(SWT.CENTER);
		player2CardName.setBounds(10, 10, 103, 21);
		
		Label p2HalalozasiLabel = new Label(canvas_1, SWT.NONE);
		p2HalalozasiLabel.setVisible(false);
		p2HalalozasiLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		p2HalalozasiLabel.setBackground(SWTResourceManager.getColor(255, 204, 102));
		p2HalalozasiLabel.setText("Halálozási arány");
		p2HalalozasiLabel.setAlignment(SWT.CENTER);
		p2HalalozasiLabel.setBounds(10, 49, 103, 15);
		
		Label p2AldozatokLabel = new Label(canvas_1, SWT.NONE);
		p2AldozatokLabel.setVisible(false);
		p2AldozatokLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		p2AldozatokLabel.setBackground(SWTResourceManager.getColor(255, 204, 102));
		p2AldozatokLabel.setText("Áldozatok");
		p2AldozatokLabel.setAlignment(SWT.CENTER);
		p2AldozatokLabel.setBounds(10, 91, 103, 15);
		
		Label p2LappangasLabel = new Label(canvas_1, SWT.NONE);
		p2LappangasLabel.setVisible(false);
		p2LappangasLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		p2LappangasLabel.setBackground(SWTResourceManager.getColor(255, 204, 102));
		p2LappangasLabel.setText("Lappangás");
		p2LappangasLabel.setAlignment(SWT.CENTER);
		p2LappangasLabel.setBounds(10, 133, 103, 15);
		
		CLabel p2HalazasiRata = new CLabel(canvas_1, SWT.NONE);
		p2HalazasiRata.setVisible(false);
		p2HalazasiRata.setBackground(SWTResourceManager.getColor(255, 204, 102));
		p2HalazasiRata.setText("0%");
		p2HalazasiRata.setAlignment(SWT.CENTER);
		p2HalazasiRata.setBounds(31, 70, 61, 15);
		
		CLabel p2AldozatokData = new CLabel(canvas_1, SWT.NONE);
		p2AldozatokData.setVisible(false);
		p2AldozatokData.setBackground(SWTResourceManager.getColor(255, 204, 102));
		p2AldozatokData.setText("0.0/100k");
		p2AldozatokData.setAlignment(SWT.CENTER);
		p2AldozatokData.setBounds(5, 112, 113, 15);
		
		CLabel p2LappangasData = new CLabel(canvas_1, SWT.NONE);
		p2LappangasData.setVisible(false);
		p2LappangasData.setBackground(SWTResourceManager.getColor(255, 204, 102));
		p2LappangasData.setText("0nap");
		p2LappangasData.setAlignment(SWT.CENTER);
		p2LappangasData.setBounds(18, 154, 87, 15);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(139, 160, 156, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(139, 119, 156, 2);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(139, 203, 156, 2);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(10, 49, 414, 2);
	
		
		btnKivlaszt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(isNewTurn){
					player2CardName.setText(table.getOtherPlayer().getHand().getTopCard().getName());
					p2HalazasiRata.setText(String.valueOf(table.getOtherPlayer().getHand().getTopCard().getLethality()) + "%");
					p2AldozatokData.setText(String.valueOf(table.getOtherPlayer().getHand().getTopCard().getVictims()) + "/100k");
					p2LappangasData.setText(String.valueOf(table.getOtherPlayer().getHand().getTopCard().getIncubationTime()) + "nap");
					
					player2CardName.setVisible(true);
					p2HalalozasiLabel.setVisible(true);
					p2HalazasiRata.setVisible(true);
					p2AldozatokLabel.setVisible(true);
					p2AldozatokData.setVisible(true);
					p2LappangasLabel.setVisible(true);
					p2LappangasData.setVisible(true);
					
					isNewTurn = false;
				}
				else{				
					player2CardName.setVisible(false);
					p2HalalozasiLabel.setVisible(false);
					p2HalazasiRata.setVisible(false);
					p2AldozatokLabel.setVisible(false);
					p2AldozatokData.setVisible(false);
					p2LappangasLabel.setVisible(false);
					p2LappangasData.setVisible(false);
					
					
					
					
					isNewTurn = true;
				}
			}
		});

	}
}
