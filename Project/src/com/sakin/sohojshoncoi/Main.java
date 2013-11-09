package com.sakin.sohojshoncoi;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.sakin.sohojshoncoi.database.Account;
import com.sakin.sohojshoncoi.database.DatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Main extends Activity {

	private DatabaseHelper databaseHelper = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		databaseHelper = getHelper();
		// here we try inserting data in the on-create as a test
		RuntimeExceptionDao<Account, Integer> dao = databaseHelper.getAccountDAO();
		// create some entries in the onCreate
		Account account = new Account("testing", 0.0, 0.0);
		dao.create(account);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    if (databaseHelper != null) {
	        OpenHelperManager.releaseHelper();
	        databaseHelper = null;
	    }
	}

	private DatabaseHelper getHelper() {
	    if (databaseHelper == null) {
	        databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
	    }
	    return databaseHelper;
	}
}
