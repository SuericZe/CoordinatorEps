package suericze.coordinatoreps;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 *
 */
public class CoordinatorLayoutFloatingActivity extends AppCompatActivity {

    private Button mButton;
    private CoordinatorLayout mCoordinator;
    private RelativeLayout rl_all;
    private FloatingActionButton nocoordinator_actionbutton;

    public static void start(Context context){
        context.startActivity(new Intent(context,CoordinatorLayoutFloatingActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coodinator_layout_floating);

        initView();
        switchLayout();

    }

    private void initView() {
        rl_all = (RelativeLayout) findViewById(R.id.rl_all);
        nocoordinator_actionbutton = (FloatingActionButton) findViewById(R.id.nocoordinator_actionbutton);
        mButton = (Button) findViewById(R.id.bt_switch);
        mCoordinator = (CoordinatorLayout) findViewById(R.id.coordinator_floating_snack);
    }

    private void switchLayout() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件要做4件事
                //1 如果CoordinatorLayout是显示状态,就隐藏,2 第一个FloatingActonBar显示, 3 button更改字体
                //4 同时弹出snackbar,这里注意,弹出是依附的view是不一样的
                boolean isCoordinatorShow = mCoordinator.getVisibility() == View.VISIBLE;
                if (isCoordinatorShow){
                    mCoordinator.setVisibility(View.GONE);
                    nocoordinator_actionbutton.setVisibility(View.VISIBLE);
                    mButton.setText(getResources().getString(R.string.switch_no_coordinatorlayout));
                    showSnackbar(rl_all,"no coordinator");
                }else {
                    nocoordinator_actionbutton.setVisibility(View.GONE);
                    mCoordinator.setVisibility(View.VISIBLE);
                    mButton.setText(getResources().getString(R.string.switch_with_coordinatorlayout));
                    showSnackbar(mCoordinator,"with coordinator");
                }
            }
        });
    }

    /**
     * 弹出Snackbar
     * @param view  snackbar要依附于那个view进行显示
     * @param result
     */
    private void showSnackbar(View view,CharSequence result){
        Snackbar.make(view,result,Snackbar.LENGTH_SHORT).show();
    }
}
