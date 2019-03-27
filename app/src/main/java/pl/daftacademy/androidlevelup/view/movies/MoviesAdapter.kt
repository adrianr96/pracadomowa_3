package pl.daftacademy.androidlevelup.view.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.entity.Movie

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var items = emptyList<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_movie, parent, false)
        return MovieViewHolder(view)
    }

    fun filtr(name: String) {
        if(name.equals("All"))
            return

        items = items.filter {
                movie -> movie.genres.contains(name)
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}