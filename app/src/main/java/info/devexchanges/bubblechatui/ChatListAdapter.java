package info.devexchanges.bubblechatui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatListAdapter extends ArrayAdapter<ChatMessage>{

    private Activity activity;
    private ArrayList<ChatMessage> chatMessages;

    public ChatListAdapter(Activity context, int resource, ArrayList<ChatMessage> objects) {
        super(context, resource, objects);
        this.activity =context;
        this.chatMessages = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource; // determined by view type
        ChatMessage chatMessage = getItem(position);

        if (chatMessage.isMine()) {
            layoutResource = R.layout.item_out;
        } else {
            layoutResource = R.layout.item_in;
        }

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //set message content
        holder.message.setText(chatMessage.getMessage());

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    static class ViewHolder {
        private TextView message;

        public ViewHolder(View v) {
            message = (TextView)v.findViewById(R.id.text);
        }
    }
}