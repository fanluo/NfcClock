package andy.nfc.clock;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextView = (TextView) findViewById(R.id.punch_time);
        initToolbar(mToolbar);
    }

    private void initToolbar(Toolbar toolbar) {
//        toolbar.setLogo(R.drawable.ic_launcher);
        toolbar.setTitle(R.string.title_main);
        toolbar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_help:
                        showHelpDialog();
                        break;
                }
                return false;
            }
        });
    }

    private void showHelpDialog() {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.label_help)
                .setMessage(R.string.label_help_desc)
                .create();
        dialog.show();
    }
}
