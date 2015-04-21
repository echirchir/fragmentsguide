package com.simple.developer.fragments.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.simple.developer.fragments.activities.CoreAppActivity;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;


public class FeedbackAsync extends AsyncTask <String, Void, Boolean> {
    protected Context context;
    private HtmlEmail email;


    public FeedbackAsync(Context cxt)
    {
        this.context = cxt;
    }

    @Override
    protected Boolean doInBackground(String... params)
    {
        try {
            String subject = params[0];
            String body = params[1];


            email = new HtmlEmail();
            email.setAuthenticator(new DefaultAuthenticator("elisha@essential-elements.net", "$_KIPsigei2003#"));
            email.setSmtpPort(587);
            email.setHostName("smtp.gmail.com");
            email.setDebug(true);

            email.addTo("elisha.java@gmail.com", "Fragments Ultimate Guide - Feedback");
            email.setFrom("elisha@essential-elements.com", "Fragments Ultimate Guide");
            email.setSubject(subject);

            email.getMailSession().getProperties().put("mail.smtps.auth", "true");
            email.getMailSession().getProperties().put("mail.debug", "true");
            email.getMailSession().getProperties().put("mail.smtps.port", "587");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
            email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");

            email.setTextMsg(body);

            email.send();

            return true;
        }catch (Exception e)
        {}

        return false;
    }

    @Override
    public void onPostExecute(Boolean result)
    {

        Intent intent = new Intent(context, CoreAppActivity.class);

        Toast.makeText(context, "Thank you for your great feedback. I truly appreciate it.", Toast.LENGTH_LONG).show();
        context.startActivity(intent);
    }


}