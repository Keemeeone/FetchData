package com.example.fetchdata;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //initializing the TextView
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv2 = findViewById(R.id.tv1);
        tv2.setMovementMethod(new ScrollingMovementMethod());
        tv3 = findViewById(R.id.tv2);
        tv3.setMovementMethod(new ScrollingMovementMethod());
        tv4 = findViewById(R.id.tv3);
        tv4.setMovementMethod(new ScrollingMovementMethod());
    }

    /**
     * list Id 1
     */
    public void click1(View view) {
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("jsons/hiring.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();

            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }
            // get string from buffer
            String jsonData = buffer.toString();

            // create JSONArray using jsonData
            JSONArray jsonArray = new JSONArray(jsonData);
            JSONArray sortArray = new JSONArray();
            JSONObject jsonObject;

            // create List
            List<JSONObject> jsonValues = new ArrayList<>();

            StringBuilder str = new StringBuilder("Group by listId:1 \n");

            //capturing the jsonArray in list
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonValues.add(jsonArray.getJSONObject(i));
            }

            //sorting by name in list
            jsonValues.sort(new Comparator<JSONObject>() {
                private static final String KEY_NAME = "name";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String list1;
                    String list2;
                    try {
                        list1 = a.getString(KEY_NAME);
                        list2 = b.getString(KEY_NAME);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    return list1.compareTo(list2);

                }
            });
            for (int i = 0; i < jsonArray.length(); i++) {
                sortArray.put(jsonValues.get(i));
            }

            // Grouping by listId
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = sortArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                int listId = jsonObject.getInt("listId");
                String name = jsonObject.getString("name");
                for (int j = 0; j < 2; j++) {
                    if (listId == j) {
                        // filter out name which is "" or null
                        if (!name.equals("") && !name.equals("null")) {
                            str.append(id).append(", ").append(listId).append(", ").append(name).append("\n");
                        }
                    }
                }
            }

            tv1.setText(str.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * list Id 2
     */
    public void click2(View view) {
        AssetManager assetManager = getAssets();

        try {
            InputStream is = assetManager.open("jsons/hiring.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();

            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }
            // get string from buffer
            String jsonData = buffer.toString();

            // create JSONArray using jsonData
            JSONArray jsonArray = new JSONArray(jsonData);
            JSONArray sortArray = new JSONArray();
            JSONObject jsonObject;

            // create List
            List<JSONObject> jsonValues = new ArrayList<>();

            StringBuilder str = new StringBuilder("Group by listId:2 \n");

            //capturing the jsonArray in list
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonValues.add(jsonArray.getJSONObject(i));
            }

            //sorting by name in list
            jsonValues.sort(new Comparator<JSONObject>() {
                private static final String KEY_NAME = "name";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String list1;
                    String list2;
                    try {
                        list1 = a.getString(KEY_NAME);
                        list2 = b.getString(KEY_NAME);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    return list1.compareTo(list2);

                }
            });
            for (int i = 0; i < jsonArray.length(); i++) {
                sortArray.put(jsonValues.get(i));
            }

            // Grouping by listId
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = sortArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                int listId = jsonObject.getInt("listId");
                String name = jsonObject.getString("name");
                for (int j = 2; j < 3; j++) {
                    if (listId == j) {
                        if (!name.equals("") && !name.equals("null")) {
                            str.append(id).append(", ").append(listId).append(", ").append(name).append("\n");
                        }
                    }
                }
            }

            tv2.setText(str.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * list Id 3
     */
    public void click3(View view) {
        AssetManager assetManager = getAssets();

        try {
            InputStream is = assetManager.open("jsons/hiring.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();

            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }
            // get string from buffer
            String jsonData = buffer.toString();

            // create JSONArray using jsonData
            JSONArray jsonArray = new JSONArray(jsonData);
            JSONArray sortArray = new JSONArray();
            JSONObject jsonObject;

            // create List
            List<JSONObject> jsonValues = new ArrayList<>();

            StringBuilder str = new StringBuilder("Group by listId:3 \n");

            //capturing the jsonArray in list
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonValues.add(jsonArray.getJSONObject(i));
            }

            //sorting by name in list
            jsonValues.sort(new Comparator<JSONObject>() {
                private static final String KEY_NAME = "name";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String list1;
                    String list2;
                    try {
                        list1 = a.getString(KEY_NAME);
                        list2 = b.getString(KEY_NAME);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    return list1.compareTo(list2);

                }
            });
            for (int i = 0; i < jsonArray.length(); i++) {
                sortArray.put(jsonValues.get(i));
            }

            // Grouping by listId
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = sortArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                int listId = jsonObject.getInt("listId");
                String name = jsonObject.getString("name");
                for (int j = 3; j < 4; j++) {
                    if (listId == j) {
                        if (!name.equals("") && !name.equals("null")) {
                            str.append(id).append(", ").append(listId).append(", ").append(name).append("\n");
                        }
                    }
                }
            }

            tv3.setText(str.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * list Id 4
     */
    public void click4(View view) {
        AssetManager assetManager = getAssets();

        try {
            InputStream is = assetManager.open("jsons/hiring.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();

            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }
            // get string from buffer
            String jsonData = buffer.toString();

            // create JSONArray using jsonData
            JSONArray jsonArray = new JSONArray(jsonData);
            JSONArray sortArray = new JSONArray();
            JSONObject jsonObject;

            // create List
            List<JSONObject> jsonValues = new ArrayList<>();

            StringBuilder str = new StringBuilder("Group by listId:4 \n");

            //capturing the jsonArray in list
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonValues.add(jsonArray.getJSONObject(i));
            }

            //sorting by name in list
            jsonValues.sort(new Comparator<JSONObject>() {
                private static final String KEY_NAME = "name";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    String list1;
                    String list2;
                    try {
                        list1 = a.getString(KEY_NAME);
                        list2 = b.getString(KEY_NAME);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    return list1.compareTo(list2);

                }
            });
            for (int i = 0; i < jsonArray.length(); i++) {
                sortArray.put(jsonValues.get(i));
            }

            // Grouping by listId
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = sortArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                int listId = jsonObject.getInt("listId");
                String name = jsonObject.getString("name");
                for (int j = 4; j < 5; j++) {
                    if (listId == j) {
                        if (!name.equals("") && !name.equals("null")) {
                            str.append(id).append(", ").append(listId).append(", ").append(name).append("\n");
                        }
                    }
                }
            }

            tv4.setText(str.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}