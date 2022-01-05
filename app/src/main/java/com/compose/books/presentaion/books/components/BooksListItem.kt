package com.compose.books.presentaion.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.compose.books.R
import com.compose.books.domain.models.Book

@Composable
fun BooksListItem(book: Book, onItemClick: (Book) -> Unit) {

    Column(
        modifier = Modifier
            .wrapContentWidth()
            .clickable { onItemClick(book) }
            .padding(horizontal = 5.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .height(180.dp), elevation = 5.dp
        ) {
            Image(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(180.dp)
//                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .clip(RoundedCornerShape(10.dp))
                    .border(width = 20.dp, shape = CircleShape, color = Color.Transparent),
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(book.book_image),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        book.title?.let {
            Text(
                text = it,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis, fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Normal,
                fontSize = 13.sp, modifier = Modifier.padding(vertical = 3.dp, horizontal = 10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom
        ) {
//            Text(
//                text = "Rank is " + books.rank,
//                textAlign = TextAlign.Start,
//                color = Color.Black, fontFamily = FontFamily.Serif,
//                fontStyle = FontStyle.Normal,
//                fontSize = 13.sp
//            )
            Text(
                text = "${book.price} AED",
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontStyle = FontStyle.Normal, fontFamily = FontFamily.Serif,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Test() {
    Text(
        text = "Rank is ",
        textAlign = TextAlign.Start,
        color = Color.Black,
        fontStyle = FontStyle.Normal, fontFamily = FontFamily.Serif,
        fontSize = 14.sp
    )
}