package ee.ut.math.tvt.salessystem.ui.model;

import ee.ut.math.tvt.salessystem.domain.data.HistorySoldDates;

import org.apache.log4j.Logger;

public class HistoryDatesTableModel extends SalesSystemTableModel<HistorySoldDates> {

	public HistoryDatesTableModel() {
		super(new String[] {"Date", "Price"});
	}
	
	private static final Logger log = Logger.getLogger(HistoryDatesTableModel.class);

	@Override
	protected Object getColumnValue(HistorySoldDates item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getDate();
		case 2:
			return item.getPrice();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
    public void addItem(final HistorySoldDates item) {
        rows.add(item);
        log.debug("Added date: " + item.getDate() + " price of:  " + item.getPrice());
        fireTableDataChanged();
    }
}
