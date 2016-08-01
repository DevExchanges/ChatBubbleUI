package info.devexchanges.bubblechatui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View btnSend;
    private EditText input;
    private ArrayList<ChatMessage> messages;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_view);
        btnSend = findViewById(R.id.btn_chat_send);
        input = (EditText) findViewById(R.id.msg_type);

        //set ListView adapter first
        adapter = new ChatListAdapter(this, R.layout.item_out, messages);
        listView.setAdapter(adapter);

        //event for button SEND
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input some text...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    ChatMessage chatMessage = new ChatMessage(input.getText().toString(), isMine());
                    messages.add(chatMessage);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(adapter.getCount() - 1); //always scroll to bottom of list view
                    input.setText("");
                }
            }
        });
    }

    private boolean isMine() {
        Random random = new Random();
        Log.d("Main", "" + random.nextBoolean());
        return random.nextBoolean();
    }
}
