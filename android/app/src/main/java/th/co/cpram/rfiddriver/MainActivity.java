package th.co.cpram.rfiddriver;
import android.os.Bundle;
import com.zebra.rfid.api3.TagData;
import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.EventChannel;

public class MainActivity extends FlutterActivity implements RFIDHandler.ResponseHandlerInterface {
    private ObservableString a;
    private EventChannel channel;
    private static final String CHANNEL = "th.co.cpram.rfiddriver";
    RFIDHandler rfidHandler;
    EventChannel.EventSink mEventSink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rfidHandler = new RFIDHandler();
        rfidHandler.onCreate(this);


        channel = new EventChannel(getFlutterView(), CHANNEL);
        channel.setStreamHandler(new EventChannel.StreamHandler() {
            @Override
            public void onListen(Object listener, EventChannel.EventSink events) {
//                events.success( a1Changed.toString());
                mEventSink = events;
            }

            @Override
            public void onCancel(Object listener) {
//                cancelListening(listener);
                mEventSink = null;
            }
        });
    }


   @Override
    public void handleTagdata(TagData[] tagData) {
        final StringBuilder sb = new StringBuilder();
        for (int index = 0; index < tagData.length; index++) {
            sb.append(tagData[index].getTagID() + "\n");
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mEventSink != null){
                    mEventSink.success(sb.toString());
                }
            }
        });
    }

    @Override
    public void handleTriggerPress(boolean pressed) {
            if (pressed) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        textrfid.setText("");
                    }
                });
                rfidHandler.performInventory();
            } else
                rfidHandler.stopInventory();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


