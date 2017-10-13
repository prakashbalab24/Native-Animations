package singledev.lottie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private boolean changeFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.parent_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(changeFlag) {
                    changeAnimation("data.json");
                    changeFlag = false;
                }
                else {
                    changeAnimation("newsanim.json");
                    changeFlag = true;
                }
            }
        });
    }

    private void changeAnimation(String anim) {
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation(anim);
        animationView.loop(true);
        animationView.playAnimation();
    }
}
