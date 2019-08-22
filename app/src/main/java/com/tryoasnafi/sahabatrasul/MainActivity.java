package com.tryoasnafi.sahabatrasul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tryoasnafi.sahabatrasul.adapter.CardViewSahabatAdapter;
import com.tryoasnafi.sahabatrasul.model.Sahabat;
import com.tryoasnafi.sahabatrasul.model.SahabatData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rvSahabat;
    private ArrayList<Sahabat> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSahabat = findViewById(R.id.rv_sahabat);
        rvSahabat.setHasFixedSize(true);

        list.addAll(SahabatData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvSahabat.setLayoutManager(new LinearLayoutManager(this));
        CardViewSahabatAdapter cardViewSahabatAdapter = new CardViewSahabatAdapter(list, this);
        rvSahabat.setAdapter(cardViewSahabatAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        }
        return true;
    }
}
