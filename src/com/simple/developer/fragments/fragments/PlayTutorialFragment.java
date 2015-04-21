package com.simple.developer.fragments.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.activities.CoreAppActivity;
import com.todddavies.components.progressbar.ProgressWheel;

import java.util.HashMap;
import java.util.Locale;


public class PlayTutorialFragment extends Fragment implements TextToSpeech.OnInitListener
{

    private TextToSpeech tts;
    protected Activity mActivity;
    protected ProgressWheel pw;

    @Override
    public void onAttach(Activity act)
    {
        super.onAttach(act);
        mActivity = act;
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState)
    {
        super.onActivityCreated(saveInstanceState);
    }

    @Override
    public void onCreate(Bundle saveInstanceStete)
    {
        super.onCreate(saveInstanceStete);

        tts = new TextToSpeech(mActivity, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.player, container, false);

        pw = (ProgressWheel)view.findViewById(R.id.pw_spinner);

        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId)
            {
                pw.spin();
            }

            @Override
            public void onDone(String utteranceId)
            {
                pw.stopSpinning();

                mActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        AlertDialog.Builder alert = new AlertDialog.Builder(mActivity);
                        alert.setTitle("Do you want to replay?");

                        alert.setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton)
                            {
                                play();
                                dialog.dismiss();
                            }
                        });

                        alert.setNegativeButton("Done",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton)
                                    {
                                        Intent intent = new Intent(mActivity, CoreAppActivity.class);
                                        mActivity.startActivity(intent);
                                        dialog.dismiss();
                                    }
                                });

                        alert.show();
                    }
                });
            }

            @Override
            public void onError(String utteranceId)
            {
                mActivity.runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        Toast.makeText(mActivity, mActivity.getString(R.string.text_to_speech_error), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }

    @Override
    public void onInit(int code)
    {
        if (code == TextToSpeech.SUCCESS)
        {
            tts.setLanguage(Locale.getDefault());

            float rate = (float)0.9;
            tts.setSpeechRate(rate);

            play();

        } else
        {
            tts = null;
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onDestroy()
    {
        if (tts!=null)
        {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }

    private void play()
    {
        if (tts != null)
        {
            String text = mActivity.getString(R.string.tutorial_summary);
            if (!tts.isSpeaking())
            {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "messageID");
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
            }

        }

    }
}
