package suericze.coordinatoreps.CusBehavior;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import suericze.coordinatoreps.R;

public class MyCusBehaviorActivity extends AppCompatActivity {
    private CoordinatorLayout mCoorLayout;
    private FloatingActionButton mFloatButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cus_behavior);

        mCoorLayout = (CoordinatorLayout) findViewById(R.id.main_content );
        mFloatButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mCoorLayout,"Cus Clicked",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,MyCusBehaviorActivity.class));
    }
}
