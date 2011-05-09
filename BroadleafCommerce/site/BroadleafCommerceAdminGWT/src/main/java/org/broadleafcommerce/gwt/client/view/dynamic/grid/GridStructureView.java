package org.broadleafcommerce.gwt.client.view.dynamic.grid;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class GridStructureView extends HStack implements GridStructureDisplay {
	
	protected ToolStrip toolBar;
	protected ToolStripButton addButton;
	protected ToolStripButton removeButton;
	protected ListGrid grid;

	public GridStructureView(String title, Boolean canReorder, Boolean canEdit) {
		super(10);
		
		setHeight(200);
        setWidth100();
        setBackgroundColor("#eaeaea");
        setAlign(Alignment.CENTER);
        
        VStack stack = new VStack();
        stack.setHeight(150);
        stack.setWidth100();
        stack.setLayoutMargin(12);
        
        toolBar = new ToolStrip();
        toolBar.setHeight(26);
        toolBar.setWidth100();
        toolBar.setMinWidth(300);
        toolBar.addSpacer(6);
        addButton = new ToolStripButton();  
        addButton.setIcon(GWT.getModuleBaseURL()+"sc/skins/Enterprise/images/headerIcons/plus.png"); 
        addButton.setDisabled(true);
        toolBar.addButton(addButton);
        removeButton = new ToolStripButton();
        removeButton.setIcon(GWT.getModuleBaseURL()+"sc/skins/Enterprise/images/headerIcons/minus.png"); 
        removeButton.setDisabled(true);
        toolBar.addButton(removeButton);
        toolBar.setDisabled(false);
        Label crossSaleLabel = new Label();
        crossSaleLabel.setContents(title);
        crossSaleLabel.setWrap(false);
        toolBar.addSpacer(6);
        toolBar.addMember(crossSaleLabel);
        toolBar.addFill();
        stack.addMember(toolBar);
        grid = new ListGrid();
        grid.setAutoFetchData(false);
        grid.setShowHeader(true);
        grid.setShowHeaderContextMenu(false); 
        grid.setPreventDuplicates(true);
        grid.setCanReorderRecords(canReorder);
        grid.setHeight100();
        grid.setDisabled(true);
        grid.setCanSort(false);
        grid.setCellPadding(5);
        grid.setCanEdit(canEdit);
        grid.setEditEvent(ListGridEditEvent.DOUBLECLICK);
        grid.setEditByCell(true);
        grid.setAutoSaveEdits(true);
        grid.setSaveByCell(true);
        grid.setAlternateRecordStyles(true);
        if (!canEdit) {
        	grid.setAlternateBodyStyleName("editRowDisabled");
        }
        stack.addMember(grid);
        
        addMember(stack);
        setOverflow(Overflow.AUTO);
	}

	public ToolStrip getToolBar() {
		return toolBar;
	}

	public ToolStripButton getAddButton() {
		return addButton;
	}

	public ToolStripButton getRemoveButton() {
		return removeButton;
	}

	public ListGrid getGrid() {
		return grid;
	}

}
