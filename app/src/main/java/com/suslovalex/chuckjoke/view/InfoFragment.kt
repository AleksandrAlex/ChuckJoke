package com.suslovalex.chuckjoke.view

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.suslovalex.chuckjoke.R
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_info.view.*


class InfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val webView: WebView = view.findViewById(R.id.webView)
//        webView.loadUrl("http://www.icndb.com/")
//        webView.loadUrl("https://www.google.com/")
//        webView.loadUrl("https://www.youtube.com/")

        // к сожалению не понял как открыть сайт http://www.icndb.com/ прямой ссылкой, поэтому написал так:
        webView.loadUrl(" https://www.google.com/search?source=hp&ei=jblCX4zbMOforgTrppOoDQ&q=icndb+api&oq=icndb+api&gs_lcp=ChFtb2JpbGUtZ3dzLXdpei1ocBADUABYAGD3AmgAcAB4AIABAIgBAJIBAJgBAA&sclient=mobile-gws-wiz-hp")
        webView.settings.javaScriptEnabled = true
        return view
    }

}
