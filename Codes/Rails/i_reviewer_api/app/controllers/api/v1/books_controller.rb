class Api::V1::BooksController < Api::V1::BaseController
  before_action :set_book, only: [:update_book, :destroy_book]

  def index
    @books = Reviewer.first.books.paginate(page: params[:page], per_page: 10)
    render(
      json: @books.as_json(:include => :notes),
      status: 201
      )
  end


  def create
    @book = Reviewer.first.books.new(book_params)

    if @book.save
      render(
        json: @book.as_json,
        status: 201
        )
    else
      render json: @book.errors, status: :unprocessable_entity
    end
    
  end

  def update_book
    if @book.update(book_params)
      render(
        json: @book.as_json(:include => :notes),
        status: 201
        ) 
    else
      render json: @book.errors, status: :unprocessable_entity
    end
    
  end

  def destroy_book

    if @book.destroy
      render(
        json: @book.as_json,
        status: 201
        ) 
    else
      render(
        json: @book.as_json,
        status: 401
        ) 

    end  
     
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_book
      @book = Reviewer.first.books.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def book_params
      params.permit(:name, :author)
    end
  end
