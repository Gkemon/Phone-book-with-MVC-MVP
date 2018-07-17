package binarygeek.phonebookWithMVP.MainView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import binarygeek.phonebookWithMVP.R;

public class MainActivity extends AppCompatActivity implements MainViewPresenterContract.MainView {

    MainAdapter mainAdapter;
    RecyclerView recyclerView;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIinitialization();
        mainPresenter = new  MainPresenter(this);

    }

    void UIinitialization(){
         recyclerView = findViewById(R.id.division_recycler);
    }

    @Override
    public void setDivisions(List<String> divisionList) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

         mainAdapter = new MainAdapter(divisionList);
         mainAdapter.setOnItemClickListener(this);
         recyclerView.setAdapter(mainAdapter);


         Log.d("GK","setDivisions. Size : "+mainAdapter.getItems().size());
    }



    @Override
    public void onItemClick(int position, View view) {
        mainPresenter.setGlobalDataAfterClickDivision(position);


        //এখানে ডাটাবেজ থেকে জেলা এনে জেলার এরেলিস্ট ইনপুট করে দে।
        mainPresenter.goToDistrictActivity(this,);

        Log.d("GK","onItemClick");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.start();
    }
}
