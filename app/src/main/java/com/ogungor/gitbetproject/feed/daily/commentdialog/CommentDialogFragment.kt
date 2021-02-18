package com.ogungor.gitbetproject.feed.daily.commentdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.ogungor.gitbetproject.R

class CommentDialogFragment(val comment:String,val bet:String,val homeTeam:String,val awayTeam:String) : DialogFragment() ,CommentDialogFragmentContract.View{
    private lateinit var commentDialogTextView: TextView
    private lateinit var teamsDialogTextView: TextView
    private lateinit var betsDialogTextView: TextView
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
        betsDialogTextView=view.findViewById(R.id.bet_name_text)
        commentDialogTextView.text= comment
        teamsDialogTextView.text="$homeTeam - $awayTeam"
        betsDialogTextView.text=bet
        commentDialogFragmentPresenter.create()
        return view
    }

    override fun initUi() {
    }
}