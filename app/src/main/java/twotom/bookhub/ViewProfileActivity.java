package twotom.bookhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        UserManager um = new UserManager();
        final boolean userProfile = um.getCurrentUser().getUsername() == ((User) (getIntent().getExtra("seller"))).getUsername();

        if(userProfile)
            ((Button) (findViewById(R.id.vProfile_EditProfile))).setText("Edit Profile");
        else
            ((Button) (findViewById(R.id.vProfile_EditProfile))).setText("Verify Transaction");
        (findViewById(R.id.vProfile_EditProfile)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start WishlistActivity.class
                if(userProfile) {
                    Intent myIntent = new Intent(ViewProfileActivity.this, ProfileActivity.class);
                    startActivity(myIntent);
                }
                else
                {
                    //TODO: complete Verify Transaction entry
                }
            }
        });
    }

}
