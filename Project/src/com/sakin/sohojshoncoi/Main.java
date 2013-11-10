package com.sakin.sohojshoncoi;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.sakin.sohojshoncoi.database.Account;
import com.sakin.sohojshoncoi.database.Category;
import com.sakin.sohojshoncoi.database.DatabaseHelper;
import com.sakin.sohojshoncoi.database.Media;
import com.sakin.sohojshoncoi.database.MediaCategory;
import com.sakin.sohojshoncoi.database.Reminder;
import com.sakin.sohojshoncoi.database.Transaction;
import com.sakin.sohojshoncoi.daylihisab.DayliHisabMain;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

	private DatabaseHelper databaseHelper = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		databaseHelper = getHelper();
		// here we try inserting data in the on-create as a test
//		RuntimeExceptionDao<Account, Integer> accountDAO = databaseHelper.getAccountDAO();
//		Account account = new Account();
//		accountDAO.create(account);
		
		Button dayliHisabB = (Button)findViewById(R.id.dayliHisabB);
		dayliHisabB.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent loginIntent = new Intent(Main.this, DayliHisabMain.class);
		        startActivity(loginIntent);
			}
		});
		
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
