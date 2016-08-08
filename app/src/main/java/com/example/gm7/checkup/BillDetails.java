package com.example.gm7.checkup;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.askerlap.emadahmed.checkup.R;

import java.util.ArrayList;

public class BillDetails extends AppCompatActivity {
private ListView list_layout;
   ArrayList<String> shopAddresses,shop_Phones,dates,shopnames,itemNames;
    DBShopsHelper shopsHelper;
    LoginDataBaseAdapter loginHelper;
    DBSalesItems salesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
      //  setContentView(R.layout.activity_shops);
        shopsHelper=new DBShopsHelper(this);
        salesHelper=new DBSalesItems(this);

        loginHelper=new LoginDataBaseAdapter(this);
        loginHelper.open();
        dates=new ArrayList<>();
        shopAddresses=new ArrayList<>();
        shop_Phones=new ArrayList<>();
        shopnames=new ArrayList<>();
        itemNames=new ArrayList<>();
        shopAddresses=shopsHelper.getShopAddress(loginHelper.getUserName());
        shop_Phones=shopsHelper.getShopPhones();
        dates=salesHelper.getDate(loginHelper.getUserName());
        shopnames=shopsHelper.getshopName();
        list_layout=(ListView)findViewById(R.id.activity_shops);
        list_layout.setAdapter(new ListAct(this,shopAddresses,shop_Phones ,dates,shopnames,itemNames));

//        setListAdapter(new ListAct(this, Android));


    }



}