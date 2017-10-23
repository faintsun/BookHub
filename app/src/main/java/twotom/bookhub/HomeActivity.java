package twotom.bookhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onLogout(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = NetworkConfiguration.getURL() + "logout";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent myIntent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        }, Utilities.getErrorListener(this));
        queue.add(stringRequest);
    }

    public void onFindBooks(View view) {
        Intent myIntent = new Intent(this, BookSearchActivity.class);
        startActivity(myIntent);
    }

    public void onWishList(View view) {
        Intent myIntent = new Intent(this, WishListActivity.class);
        startActivity(myIntent);
    }

    public void onMyBooks(View view) {
        Intent myIntent = new Intent(this, MyBooksActivity.class);
        startActivity(myIntent);
    }

    public void onProfile(View view) {
        Intent myIntent = new Intent(this, ProfileActivity.class);
        startActivity(myIntent);
    }

    public void onTransaction(View view) {
        Intent intent = new Intent(this, TransactionHistoryActivity.class);
        startActivity(intent);
    }
}
