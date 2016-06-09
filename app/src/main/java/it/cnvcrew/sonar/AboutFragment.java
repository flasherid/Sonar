package it.cnvcrew.sonar;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * Created by Alunno on 07/05/2016.
 */
public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        PackageInfo pInfo = null;
        try {
            pInfo = this.getActivity().getPackageManager()
                    .getPackageInfo(this.getActivity().getPackageName(), 0);        /*  Gets the version number */
        }catch(PackageManager.NameNotFoundException e){}
        Element versionElement = new Element().setTitle(pInfo.versionName);
        View aboutPage = new AboutPage(this.getContext())
                .isRTL(false)
                .setImage(R.drawable.cnv_logo)
                .addItem(versionElement)
                .addGroup("Connect with us")
                .addEmail("cnvriparazioni@gmail.com")
                .addWebsite("http://cnvcrew.github.io/")
                .addFacebook("lapseofreason")
                .addTwitter("MrDrusi")
                .addGitHub("CNVCrew")
                .addInstagram("filippo_gas")
                .create();

        return aboutPage;
    }

}
