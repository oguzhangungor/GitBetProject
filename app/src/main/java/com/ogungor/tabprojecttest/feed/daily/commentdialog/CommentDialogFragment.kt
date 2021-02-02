package com.ogungor.tabprojecttest.feed.daily.commentdialog

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.ogungor.tabprojecttest.R

class CommentDialogFragment(var comment:String,var teamList:String) : DialogFragment() ,CommentDialogFragmentContract.View{
    private lateinit var commentDialogTextView: TextView
    private lateinit var teamsDialogTextView: TextView
    private lateinit var commentDialogFragmentPresenter: CommentDialogFragmentContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        commentDialogFragmentPresenter=CommentDialogFragmentPresenter().apply {
            setView(this@CommentDialogFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view=inflater.inflate(R.layout.fragment_comment__dialog, container, false)
        commentDialogTextView=view.findViewById(R.id.comment_dialog_text)
        teamsDialogTextView=view.findViewById(R.id.team_name_text)
        commentDialogTextView.text=comment
        teamsDialogTextView.text=teamList
        commentDialogFragmentPresenter.create()
        return view
    }

    override fun initUi() {

    }

}