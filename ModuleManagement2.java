package TabbedPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ModuleManagement2 extends JFrame{
	
	JPanel tab1, tab2;
	int selectedRow;
	
	ArrayList<Module> modules = new ArrayList<Module>();
	
	public ModuleManagement2() {
		
		super("Module Management Version 2");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTabbedPane tabs = new JTabbedPane();
		tab1 = new JPanel();
		tab2 = new JPanel();
		
		tabs.add(tab1, "Module Details");
		tabs.add(tab2, "Statistics");
		
		add(tabs);
		
		Tab1_GUI();
		Tab2_GUI();
		
	}
	
	public void Tab1_GUI() {
		
		DefaultTableModel tableModel;
		JTable table;
		JTextField txtTitle, txtCredit;
		JLabel titleLabel, creditLabel;
		JPanel inputPanel, tablePanel;
		JButton addBtn, removeBtn, updateBtn;
		
		selectedRow =-1;
		inputPanel = new JPanel();
		tablePanel = new JPanel();
		
		txtTitle = new JTextField(20);
		txtCredit = new JTextField(10);
		titleLabel = new JLabel("Title : ");
		creditLabel = new JLabel("Credit : ");
		addBtn = new JButton("Add");
		updateBtn = new JButton("Update");
		removeBtn = new JButton("Remove");
		
		inputPanel.add(titleLabel);
		inputPanel.add(txtTitle);
		inputPanel.add(creditLabel);
		inputPanel.add(txtCredit);
		inputPanel.add(addBtn);
		inputPanel.add(updateBtn);
		inputPanel.add(removeBtn);
		String[] columnsname = {"Title", "Credit"};
		tableModel = new DefaultTableModel(columnsname, 0);
		
		table = new JTable(tableModel);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// not allow to update the cells
		for (int i=0; i< columnsname.length; i++)
			table.setDefaultEditor(table.getColumnClass(i), null);
		
		JScrollPane sp = new JScrollPane(table);

		tablePanel.add(sp);
		tab1.add(inputPanel, BorderLayout.NORTH);
		tab1.add(tablePanel, BorderLayout.CENTER);
		
		//HANDLING EVENTS

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				selectedRow = table.getSelectedRow();
			
			//System.out.println("After change selected row" + selectedRow);
				if (selectedRow == -1) {
					txtTitle.setText("");
					txtCredit.setText("");
						
				}
				else {
					txtTitle.setText((String)tableModel.getValueAt(selectedRow, 0));
					txtCredit.setText((String) tableModel.getValueAt(selectedRow, 1));
					
					}
				}
			
		
			});
		
			//	selectionModel.addListSelectionListener(this);
				
			addBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if ((! txtTitle.getText().isBlank())&& (!txtCredit.getText().isBlank())) {
						Object[] row = {txtTitle.getText(), txtCredit.getText()};
						tableModel.addRow(row);
						Module module = new Module(txtTitle.getText(), Integer.parseInt(txtCredit.getText()));
						txtTitle.setText("");
						txtCredit.setText("");
						table.clearSelection();
						
						// add the row to arraylist
						modules.add(module);
						
					//	statisticCalculate();
					}
					
				}
				
			});
				
			updateBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (selectedRow != -1) {
						tableModel.setValueAt(txtTitle.getText(), selectedRow, 0);
						tableModel.setValueAt(txtCredit.getText(), selectedRow, 1);
						
						modules.get(selectedRow).setTitle(txtTitle.getText());
						modules.get(selectedRow).setCredit(Integer.parseInt(txtCredit.getText()));
						
					}
				}
				
			});
			
			removeBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (selectedRow != -1) {//&& (tableModel.getRowCount()>0)) {
						modules.remove(selectedRow);
						tableModel.removeRow(selectedRow);
					
						
						
						
					}
				}
				
			});
		
		
		
	}
	
	public void Tab2_GUI() {
		
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		tab2.setLayout(new GridLayout(2,1));
		JButton btn = new JButton("Calculation");
		JLabel label1 = new JLabel("Total credit of all modules: 0");
		JLabel label2 = new JLabel("Total modules: 0");
	
		
		pn1.add(btn);
		pn2.add(label1);
		pn2.add(label2);
		
		tab2.add(pn1);
		tab2.add(pn2);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int totalCredit =0;
				for ( Module module: modules) {
					totalCredit = totalCredit + module.getCredit();
				}
				
				label1.setText("Total credit of all modules: " + String.valueOf(totalCredit));
				label2.setText("Total modules: " + String.valueOf(modules.size()));
			}
			
			
		});
		
	
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModuleManagement2 win = new ModuleManagement2();
		win.setSize(700,300);
		win.setVisible(true);

	}

}
