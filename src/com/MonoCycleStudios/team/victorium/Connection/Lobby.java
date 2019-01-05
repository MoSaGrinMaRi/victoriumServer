package com.MonoCycleStudios.team.victorium.Connection;

import com.MonoCycleStudios.team.victorium.Connection.Enums.CommandType;
import com.MonoCycleStudios.team.victorium.Game.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lobby {

    public static int gPort = 52232;
    public static int MAX_PLAYERS = 6;
    public static int MIN_PLAYERS_TO_START = 2;
//
//    public static ListView lv;
//    private static LinearLayout ll;
//    public static OurArrayListAdapter adapter;
//    public static Button b1;
//    public static Button b2;
//    public static Button b3;
//    public EditText tvSip;
    public static Server s1;
//    public static Client c1;
    static String lPlayerName;
    static boolean lIsServer = false;

    public static Lobby thisActivity;   // need another approach, i guess...

    static ArrayList<Player> playerArrayList = new ArrayList<>();

//    BitmapFactory.Options bmo = new BitmapFactory.Options();
//    public static Bitmap flagAtlas;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lobby);

//        thisActivity = this;


//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//        overridePendingTransition(R.animator.slideout_right, R.animator.slidein_left);
//
//        ll = (LinearLayout) findViewById(R.id.llLobbyPlayersList);
//
//        b1 = (Button)findViewById(R.id.btnConnect);

//        b1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v){
//                ((Button)findViewById(R.id.btnConnect)).setEnabled(false);
//                ((Button)findViewById(R.id.btnConnect)).setClickable(false);
////                ((Button)findViewById(R.id.connectBtn)).setText("Connecting");
//
//                c1 = new Client();
//                System.out.println("[=2.1=].................");
////                c1.init(Lobby.this);
//                c1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, lIsServer ? getMyLocalIP() : tvSip.getText().toString(), lPlayerName);
//                System.out.println("[=2.2=].................");
//
//                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
//                        0,
//                        0,
//                        40.0f
//                );
//                findViewById(R.id.view2).setLayoutParams(param);
//                TransitionManager.beginDelayedTransition(((LinearLayout)findViewById(R.id.llLobbyControl)));
//                TransitionManager.beginDelayedTransition(ll);
//                ll.setVisibility(View.VISIBLE);
//                tvSip.setEnabled(false);
//            }
//        });

//        b2 = (Button)findViewById(R.id.btnLobbyBack);
//        b2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v){
//                onBackPressed();
//            }
//        });

//        b3 = (Button)findViewById(R.id.btnLaunchGame);
//        b3.setEnabled(false);

                                        //        b3.setOnClickListener(new View.OnClickListener(){
                                        //            @Override
                                        //            public void onClick (View v){
                                        //                b3.setEnabled(false);
                                        //                s1.notifyAllClients(new MonoPackage("", CommandType.STARTGAME.getStr(),null));
                                        //                s1.stopListening(false);
                                        //            }
                                        //        });

//        lv = (ListView) findViewById(R.id.connectionsListView);

//        tvSip = (EditText) findViewById(R.id.InpIpAddress);
//        if (lIsServer){
//            System.out.println("set invisible");
//            tvSip.setEnabled(false);
//            tvSip.setText(getMyLocalIP());
//            System.out.println("[=1=].................");
//            s1 = new Server();
//            System.out.println("[=1.1=].................");
//            s1.run();//.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
//            System.out.println("[=1.2=].................");

//            b1.performClick();
//            b1.setVisibility(View.INVISIBLE);
//        }else{
//            b3.setVisibility(View.INVISIBLE);
//        }

//        adapter = new OurArrayListAdapter(this, android.R.layout.simple_list_item_1, playerArrayList);
//        forceREUpdateAdapter();

//        bmo.inScaled = true;
////        bmo.inSampleSize = 32;
//        bmo.inDensity = 468;
//        bmo.inTargetDensity = 468;
//        flagAtlas = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.flag_atlas, bmo);

    public Lobby(){
        s1 = new Server();
        System.out.println("[=1.1=].................");
        s1.run();//.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
        System.out.println("[=1.2=].................");
    }

    public void onStartGame(){

        // call it when room initiator hit button start

        s1.notifyAllClients(new MonoPackage("", CommandType.STARTGAME.getStr(),null));
        s1.stopListening(false);
    }

//    public class OurArrayListAdapter extends ArrayAdapter<Player> {
////        public OurArrayListAdapter(Context context, int textViewResourceId) {
////            super(context, textViewResourceId);
////        }
//
//        public OurArrayListAdapter(Context context, int resource, ArrayList<Player> items) {
//            super(context, resource, items);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View v = convertView;
//            if (v == null) {
//                LayoutInflater vi;
//                vi = LayoutInflater.from(getContext());
//                v = vi.inflate(R.layout.itemlistrow, null);
//            }
//
//            Player p = getItem(position);
//            if (p != null) {
//                ImageView im1 = (ImageView) v.findViewById(R.id.imageView);
//                TextView tt1 = (TextView) v.findViewById(R.id.playerName);
//                TextView tt3 = (TextView) v.findViewById(R.id.playerScore);
//
//                if (tt1 != null)
//                    tt1.setText(p.getPlayerName());
//                if (tt3 != null) {
//                    System.out.println("[1][][] "+ p.getPlayerScore() + p.getPlayerName() );
//                    tt3.setText(String.valueOf(p.getPlayerScore()));
//                }
//                if (im1 != null) {
//
//                    int frameWidth = 78;
//                    int frameHeight = 140;
//                    int frameCountX = 0;    //  MAX = 6; Only 6 player
//
//                    switch (p.getPlayerCharacter().getColor()){
//                        case RED:
//                            frameCountX = 0;
//                            break;
//                        case BLUE:
//                            frameCountX = 1;
//                            break;
//                        case ORANGE:
//                            frameCountX = 2;
//                            break;
//                        case GREEN:
//                            frameCountX = 3;
//                            break;
//                        case BLACK:
//                            frameCountX = 4;
//                            break;
//                        case PURPLE:
//                            frameCountX = 5;
//                            break;
//
//                    }
//
//                    im1.setImageBitmap(Bitmap.createBitmap(Lobby.flagAtlas,
//                            frameWidth * frameCountX,
//                            0,
//                            frameWidth,
//                            frameHeight));
//
////                    im1.setColorFilter(p.getPlayerCharacter().getColor().getARGB());
////                    System.out.println("[][][] " + Client.iPlayer != null + " " + p.getPlayerID() + "|" + (Client.iPlayer != null ? Client.iPlayer.getPlayerID() :-1) + "="  +(p.getPlayerID() == (Client.iPlayer != null ? Client.iPlayer.getPlayerID() :-1)));
////                    if(Client.iPlayer != null && p.getPlayerID() == Client.iPlayer.getPlayerID()) {
////                        im1.setBackground(getDrawable(R.drawable.shape_tablerow_image));
////                    }
//                }
//            }
//            return v;
//        }
//
//    }

//    public static void forceREUpdateAdapter(){
//        adapter.clear();
//        adapter.addAll(playerArrayList);
//        adapter.notifyDataSetChanged();
//        lv.setAdapter(adapter);
//    }

    public static synchronized void statusUpdate(String s){
        System.out.println("[LOBBY STATUS] " + s);
    }

    public void setConfig(boolean isServer, String playerName){
        lIsServer = isServer;
        lPlayerName = playerName;
    }

    public static void startGameActivity(){

        System.out.println("YEY!");

        Collections.sort(Lobby.getPlayersList());

//        thisActivity.startActivity(new Intent(thisActivity, Game.getInstance().getClass()));
//        thisActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        if(lIsServer){
//            Game.getInstance().setup(s1, playerArrayList.size());
//        }else{
//            Game.getInstance().setup(null, playerArrayList.size());
        }
//        c1.iPlayer.setPlayerGame(Game.getInstance());
    }

    public static String getMyLocalIP() {
        return "192.168.0.103";
    }

//    public static String getMyLocalIP(){
//        try{
//            Enumeration e = NetworkInterface.getNetworkInterfaces();
//            while(e.hasMoreElements())
//            {
//                NetworkInterface n = (NetworkInterface) e.nextElement();
//                Enumeration ee = n.getInetAddresses();
//                while (ee.hasMoreElements())
//                {
//                    InetAddress i = (InetAddress) ee.nextElement();
//                    if(isStartWith(i.getHostAddress()))
//                        return i.getHostAddress();
//                }
//            }
//        } catch (SocketException e1) {
//            e1.printStackTrace();
//        }
//        return null;
//    }

//    private static boolean isStartWith(String address){
//        String[] addressStart = {
//                "192.168.",
//                "172.16.",
//                "172.17.",
//                "172.18.",
//                "172.19.",
//                "172.20.",
//                "172.21.",
//                "172.22.",
//                "172.23.",
//                "172.24.",
//                "172.25.",
//                "172.26.",
//                "172.27.",
//                "172.28.",
//                "172.29.",
//                "172.30.",
//                "172.31."
//        };
//        for (String anAddressStart : addressStart) {
//            if (address.startsWith(anAddressStart)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static int getUnusedIndex(){
        int i = 0;
        for(; i < Lobby.MAX_PLAYERS && i < playerArrayList.size(); i++){
            System.out.println("]]=[[ " + (playerArrayList.size()-1) + " }{ " + i + " }{ " + playerArrayList.get(i).getPlayerID());
            if(i != playerArrayList.get(i).getPlayerID()){
                return i;
            }
        }
        System.out.println("]]+[[ " +i);
        return i;
    }

    public static ArrayList<Player> getPlayersList(){
        return playerArrayList;
    }
    public static void setPlayerArrayList(ArrayList<Player> playerArrayList) {
        Lobby.playerArrayList = playerArrayList;
    }

    public void stopAndClose(){
        if(s1 != null) {
            s1.cancelChild();
            s1.stopListening(true);
            try {
                s1.serverSocket.close();//cancel(true);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                s1 = null;
            }
        }

        playerArrayList.clear();

//        if(c1 != null) {
//            c1.cancel(true);
//            c1 = null;
//        }

//        TransitionManager.beginDelayedTransition(((LinearLayout)findViewById(R.id.llLobbyControl)));
//        TransitionManager.beginDelayedTransition(ll);
//        ll.setVisibility(View.GONE);


//        thisActivity = null;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            finishAfterTransition();
//        }else{
//            finish();
//        }
    }

    @Override
    public void finalize() {
        stopAndClose();
        System.out.println("Book instance is getting destroyed");
    }
}
